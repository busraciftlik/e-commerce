package com.busraciftlik.business.abstracts;

import com.busraciftlik.business.dto.requests.create.CreateCategoryRequest;
import com.busraciftlik.business.dto.requests.update.UpdateCategoryRequest;
import com.busraciftlik.business.dto.responses.create.CreateCategoryResponse;
import com.busraciftlik.business.dto.responses.get.GetAllCategoriesResponse;
import com.busraciftlik.business.dto.responses.get.GetCategoryResponse;
import com.busraciftlik.business.dto.responses.update.UpdateCategoryResponse;


import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();

    GetCategoryResponse getById(int id);

    CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest);

    UpdateCategoryResponse update(int id, UpdateCategoryRequest updateCategoryRequest);

    void delete(int id);
}
