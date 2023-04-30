package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.CategoryService;
import com.busraciftlik.business.abstracts.ProductService;
import com.busraciftlik.business.dto.requests.create.CreateProductRequest;
import com.busraciftlik.business.dto.requests.update.UpdateProductRequest;
import com.busraciftlik.business.dto.responses.create.CreateProductResponse;
import com.busraciftlik.business.dto.responses.get.GetAllProductsResponse;
import com.busraciftlik.business.dto.responses.get.GetCategoryResponse;
import com.busraciftlik.business.dto.responses.get.GetProductResponse;
import com.busraciftlik.business.dto.responses.update.UpdateProductResponse;
import com.busraciftlik.business.rules.ProductBusinessRules;
import com.busraciftlik.entities.Category;
import com.busraciftlik.entities.Product;
import com.busraciftlik.entities.enums.Status;
import com.busraciftlik.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ProductBusinessRules rules;


    @Override
    public List<GetAllProductsResponse> getAll(boolean includePassive) {
        List<Product> products = filterProductsByPassiveStatus(includePassive);
        return products
                .stream().map(product -> modelMapper.map(product, GetAllProductsResponse.class))
                .toList();
    }


    @Override
    public GetProductResponse getById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        return modelMapper.map(product, GetProductResponse.class);
    }

    @Override

    public CreateProductResponse add(CreateProductRequest createProductRequest) {
        Product product = modelMapper.map(createProductRequest, Product.class);
        product.setId(0);
        for (Integer categoryId : createProductRequest.getCategoryIds()) {
            GetCategoryResponse byId = categoryService.getById(categoryId);
            Category category = modelMapper.map(byId, Category.class);
            if (byId != null) {
                product.getCategories().add(category);
            }
        }
        rules.validateProduct(product);
        productRepository.save(product);
        return modelMapper.map(product, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest updateProductRequest) {
        Product product = modelMapper.map(updateProductRequest, Product.class);
        rules.validateProduct(product);
        productRepository.save(product);
        return modelMapper.map(product, UpdateProductResponse.class);
    }

    @Override
    public void delete(int id) {

        productRepository.deleteById(id);
    }

    @Override
    public void changeStatus(int productId, Status status) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setStatus(status);
        productRepository.save(product);
    }

    private List<Product> filterProductsByPassiveStatus(boolean includePassive) {
        return includePassive ? productRepository.findAll() : productRepository.findAllByStatus(Status.ACTIVE);
    }
}