package com.busraciftlik.business.abstracts;

import com.busraciftlik.business.dto.requests.create.CreateSaleRequest;
import com.busraciftlik.business.dto.requests.update.UpdateSaleRequest;
import com.busraciftlik.business.dto.responses.create.CreateSaleResponse;
import com.busraciftlik.business.dto.responses.get.GetAllSalesResponse;
import com.busraciftlik.business.dto.responses.get.GetSaleResponse;
import com.busraciftlik.business.dto.responses.update.UpdateSaleResponse;

import java.util.List;

public interface SaleService {
    List<GetAllSalesResponse> getAll();
    GetSaleResponse getById(int id);
    CreateSaleResponse add(CreateSaleRequest request);
    UpdateSaleResponse update(int id, UpdateSaleRequest request);
    void delete(int id);
}
