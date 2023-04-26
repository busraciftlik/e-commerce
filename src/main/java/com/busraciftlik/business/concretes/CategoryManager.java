package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.CategoryService;
import com.busraciftlik.business.dto.requests.create.CreateCategoryRequest;
import com.busraciftlik.business.dto.requests.update.UpdateCategoryRequest;
import com.busraciftlik.business.dto.responses.create.CreateCategoryResponse;
import com.busraciftlik.business.dto.responses.get.GetAllCategoriesResponse;
import com.busraciftlik.business.dto.responses.get.GetCategoryResponse;
import com.busraciftlik.business.dto.responses.update.UpdateCategoryResponse;
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

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> getAllCategoriesResponses = categories
                .stream().map(category -> modelMapper.map(category, GetAllCategoriesResponse.class)).toList();
        return getAllCategoriesResponses;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse getCategoryResponse = modelMapper.map(category, GetCategoryResponse.class);
        return getCategoryResponse;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) {
        Category category = modelMapper.map(createCategoryRequest, Category.class);
        Category persistedCategory = categoryRepository.save(category);
        CreateCategoryResponse createCategoryResponse = modelMapper.map(persistedCategory, CreateCategoryResponse.class);
        return createCategoryResponse;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest updateCategoryRequest) {
        Category category = modelMapper.map(updateCategoryRequest, Category.class);
        Category persistedCategory = categoryRepository.save(category);
        UpdateCategoryResponse updateCategoryResponse = modelMapper.map(persistedCategory, UpdateCategoryResponse.class);
        return updateCategoryResponse;
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }


}
