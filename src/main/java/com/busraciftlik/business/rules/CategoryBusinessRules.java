package com.busraciftlik.business.rules;

import com.busraciftlik.common.constants.Message;
import com.busraciftlik.core.exceptions.BusinessException;
import com.busraciftlik.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExist(int id){
        if(!repository.existsById(id)){
            throw new BusinessException(Message.Category.NOT_EXISTS);
        }
    }
}
