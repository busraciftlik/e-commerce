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

    @Override
    public List<GetAllProductsResponse> getAll(boolean includePassive) {
        List<Product> products = getActiveProduct(includePassive);
        List<GetAllProductsResponse> getAllProductsResponses = products
                .stream().map(product -> modelMapper.map(product, GetAllProductsResponse.class)).toList();
        return getAllProductsResponses;
    }


    @Override
    public GetProductResponse getById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        GetProductResponse getProductResponse = modelMapper.map(product, GetProductResponse.class);
        return getProductResponse;
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
        validateProduct(product);
        productRepository.save(product);
        CreateProductResponse createdProductResponse = modelMapper.map(product, CreateProductResponse.class);
        return createdProductResponse;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest updateProductRequest) {
        Product product = modelMapper.map(updateProductRequest, Product.class);
        validateProduct(product);
        productRepository.save(product);
        UpdateProductResponse updateProductResponse = modelMapper.map(product, UpdateProductResponse.class);
        return updateProductResponse;
    }

    @Override
    public void delete(int id) {

        productRepository.deleteById(id);
    }


    //! Business rules

    private List<Product> getActiveProduct(boolean includePassive) {
        return includePassive ? productRepository.findAll() : productRepository.findAllByStatus(Status.ACTIVE);
    }
    private void validateProduct(Product product) {
        checkIfUnitPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLengthValid(product);
    }

    private void checkIfUnitPriceValid(Product product) {
        if (product.getPrice() <= 0)
            throw new IllegalArgumentException("Price cannot be less than or equal to zero.");
    }

    private void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new IllegalArgumentException("Quantity cannot be less than zero.");
    }

    private void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
    }
}