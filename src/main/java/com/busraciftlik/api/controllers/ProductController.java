package com.busraciftlik.api.controllers;

import com.busraciftlik.business.abstracts.ProductService;
import com.busraciftlik.business.dto.requests.create.CreateProductRequest;
import com.busraciftlik.business.dto.requests.update.UpdateProductRequest;
import com.busraciftlik.business.dto.responses.create.CreateProductResponse;
import com.busraciftlik.business.dto.responses.get.GetAllProductsResponse;
import com.busraciftlik.business.dto.responses.get.GetProductResponse;
import com.busraciftlik.business.dto.responses.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;


    @GetMapping
    public List<GetAllProductsResponse> getAll(@RequestParam(defaultValue = "true") boolean includePassive) {
        return service.getAll(includePassive);
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
        return service.add(createProductRequest);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest updateProductRequest) {
        return service.update(id, updateProductRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}

