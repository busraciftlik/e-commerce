package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.CategoryService;
import com.busraciftlik.business.dto.requests.create.CreateCategoryRequest;
import com.busraciftlik.business.dto.requests.update.UpdateCategoryRequest;
import com.busraciftlik.business.dto.responses.create.CreateCategoryResponse;
import com.busraciftlik.business.dto.responses.get.GetAllCategoriesResponse;
import com.busraciftlik.business.dto.responses.get.GetCategoryResponse;
import com.busraciftlik.business.dto.responses.update.UpdateCategoryResponse;
import com.busraciftlik.business.rules.CategoryBusinessRules;
import com.busraciftlik.entities.Category;
import com.busraciftlik.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final CategoryBusinessRules rules;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> getAllCategoriesResponses = categories
                .stream().map(category -> modelMapper.map(category, GetAllCategoriesResponse.class)).toList();
        return getAllCategoriesResponses;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        rules.checkIfCategoryExist(id);
        Category category = categoryRepository.findById(id).orElseThrow();
        return modelMapper.map(category, GetCategoryResponse.class);
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
        Category category = modelMapper.map(createCategoryRequest, Category.class);
        Category persistedCategory = categoryRepository.save(category);
        return modelMapper.map(persistedCategory, CreateCategoryResponse.class);
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest updateCategoryRequest) {
        rules.checkIfCategoryExist(id);
        Category category = modelMapper.map(updateCategoryRequest, Category.class);
        Category persistedCategory = categoryRepository.save(category);
        return modelMapper.map(persistedCategory, UpdateCategoryResponse.class);
    }

    @Override
    public void delete(int id) {
        rules.checkIfCategoryExist(id);
        categoryRepository.deleteById(id);
    }

}
