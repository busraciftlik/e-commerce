package com.busraciftlik.business.rules;

import com.busraciftlik.common.constants.Message;
import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.entities.Product;
import com.busraciftlik.entities.enums.Status;
import com.busraciftlik.repository.abstracts.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SaleBusinessRules {
    private final SaleRepository repository;

    public void checkIfSaleExists(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Message.Sale.NOT_EXISTS);
        }
    }

    public void checkIfProductActive(Status status){
        if(!status.equals(Status.ACTIVE)){
            throw new BusinessException(Message.Product.PRODUCT_NOT_ACTIVE);
        }
    }

    public void checkIfProductQuantity(Product product){
        if(product.getQuantity() == 0){
            throw new BusinessException(Message.Product.NOT_EXISTS);
        }
    }
}
