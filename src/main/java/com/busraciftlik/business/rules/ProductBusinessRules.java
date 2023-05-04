package com.busraciftlik.business.rules;

import com.busraciftlik.common.constants.Message;
import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.entities.Product;
import com.busraciftlik.entities.enums.Status;
import com.busraciftlik.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExists(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Message.Product.NOT_EXISTS);
        }
    }
    public void validateProduct(Product product) {
        checkIfUnitPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLengthValid(product);
    }

    public void checkIfUnitPriceValid(Product product) {
        if (product.getPrice() <= 0)
            throw new IllegalArgumentException("Price cannot be less than or equal to zero.");
    }

    public void checkIfQuantityValid(Product product) {
        if (product.getQuantity() < 0) throw new IllegalArgumentException("Quantity cannot be less than zero.");
    }

    public void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
    }
}
