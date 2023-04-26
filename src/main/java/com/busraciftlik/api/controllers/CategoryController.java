package com.busraciftlik.api.controllers;

import com.busraciftlik.business.abstracts.CategoryService;
import com.busraciftlik.business.dto.requests.create.CreateCategoryRequest;
import com.busraciftlik.business.dto.requests.update.UpdateCategoryRequest;
import com.busraciftlik.business.dto.responses.create.CreateCategoryResponse;
import com.busraciftlik.business.dto.responses.get.GetAllCategoriesResponse;
import com.busraciftlik.business.dto.responses.get.GetCategoryResponse;
import com.busraciftlik.business.dto.responses.update.UpdateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;


    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return service.add(createCategoryRequest);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable int id, @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return service.update(id, updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}