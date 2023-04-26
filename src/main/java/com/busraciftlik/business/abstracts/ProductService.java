package com.busraciftlik.business.abstracts;


import com.busraciftlik.business.dto.requests.update.UpdateProductRequest;
import com.busraciftlik.business.dto.requests.create.CreateProductRequest;
import com.busraciftlik.business.dto.responses.create.CreateProductResponse;
import com.busraciftlik.business.dto.responses.get.GetAllProductsResponse;
import com.busraciftlik.business.dto.responses.get.GetProductResponse;
import com.busraciftlik.business.dto.responses.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll(boolean includePassive);

    GetProductResponse getById(int id);

    CreateProductResponse add(CreateProductRequest createProductRequest);

    UpdateProductResponse update(int id, UpdateProductRequest updateProductRequest);

    void delete(int id);
}
