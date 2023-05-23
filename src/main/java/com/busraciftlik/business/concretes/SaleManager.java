package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.PaymentService;
import com.busraciftlik.business.abstracts.ProductService;
import com.busraciftlik.business.abstracts.SaleService;
import com.busraciftlik.business.dto.requests.CreateProductPaymentRequest;
import com.busraciftlik.business.dto.requests.create.CreateSaleRequest;
import com.busraciftlik.business.dto.requests.update.UpdateSaleRequest;
import com.busraciftlik.business.dto.responses.create.CreateSaleResponse;
import com.busraciftlik.business.dto.responses.get.GetAllSalesResponse;
import com.busraciftlik.business.dto.responses.get.GetProductResponse;
import com.busraciftlik.business.dto.responses.get.GetSaleResponse;
import com.busraciftlik.business.dto.responses.update.UpdateSaleResponse;
import com.busraciftlik.business.rules.SaleBusinessRules;
import com.busraciftlik.common.constants.Message;
import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.entities.Product;
import com.busraciftlik.entities.Sale;
import com.busraciftlik.entities.enums.Status;
import com.busraciftlik.repository.abstracts.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SaleManager implements SaleService {
    private final SaleRepository repository;
    private final ModelMapper mapper;
    private final SaleBusinessRules rules;
    private final ProductService productService;
    private final PaymentService paymentService;

    @Override
    public List<GetAllSalesResponse> getAll() {
        List<Sale> sales = repository.findAll();
        List<GetAllSalesResponse> responses = sales
                .stream().map(sale -> mapper.map(sale, GetAllSalesResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetSaleResponse getById(int id) {
        rules.checkIfSaleExists(id);
        Sale sale = repository.findById(id).orElseThrow();

        return mapper.map(sale, GetSaleResponse.class);
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        checkIfProductActive(request);
        Sale sale = mapper.map(request, Sale.class);
        sale.setId(0);
        List<Integer> productIds = request.getProductIds();
        addProduct(sale, productIds);
        sale.setTotalPrice(getTotalPrice(request.getProductIds()));
        getPayment(request, productIds);

        Sale savedSale = repository.save(sale);

        for (Integer productId : productIds) {
            productService.changeQuantity(productId);
        }

        return mapper.map(savedSale, CreateSaleResponse.class);
    }


    @Override
    public UpdateSaleResponse update(int id, UpdateSaleRequest request) {
        rules.checkIfSaleExists(id);
        Sale sale = mapper.map(request, Sale.class);
        sale.setId(id);
        Sale saveSale = repository.save(sale);
        return mapper.map(saveSale, UpdateSaleResponse.class);

    }

    @Override
    public void delete(int id) {
        rules.checkIfSaleExists(id);
        repository.deleteById(id);

    }

    private void addProduct(Sale sale, List<Integer> productIds) {
        for (Integer productId : productIds) {
            GetProductResponse byId = productService.getById(productId);
            Product product = mapper.map(byId, Product.class);
            if (byId != null) {
                sale.getProducts().add(product);
            }
        }
    }

    private void getPayment(CreateSaleRequest request, List<Integer> productIds) {
        CreateProductPaymentRequest paymentRequest = new CreateProductPaymentRequest();
        mapper.map(request.getPaymentRequest(), paymentRequest);
        paymentRequest.setPrice(getTotalPrice(productIds));
        paymentService.processProductPayment(paymentRequest);
    }

    public double getTotalPrice(List<Integer> productIds) {
        double totalPrice = 0;
        for (Integer productId : productIds) {
            GetProductResponse byId = productService.getById(productId);
            Product product = mapper.map(byId, Product.class);
            double price = product.getPrice();
            totalPrice += price;
        }
        return totalPrice;
    }

    private void checkIfProductActive(CreateSaleRequest request) {
        List<Integer> productIds = request.getProductIds();
        for (Integer productId : productIds) {
            GetProductResponse byId = productService.getById(productId);
            Product product = mapper.map(byId, Product.class);
            if (!product.getStatus().equals(Status.ACTIVE)) {
                throw new BusinessException(Message.Product.PRODUCT_NOT_ACTIVE);
            }
        }
    }
}
