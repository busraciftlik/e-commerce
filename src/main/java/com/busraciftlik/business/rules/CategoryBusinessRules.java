package com.busraciftlik.business.rules;

import com.busraciftlik.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExist(int id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Category not found");
        }
    }
}
