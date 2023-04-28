package com.busraciftlik.business.concretes;

import com.busraciftlik.business.abstracts.SaleService;
import com.busraciftlik.business.dto.requests.create.CreateSaleRequest;
import com.busraciftlik.business.dto.requests.update.UpdateSaleRequest;
import com.busraciftlik.business.dto.responses.create.CreateSaleResponse;
import com.busraciftlik.business.dto.responses.get.GetAllSalesResponse;
import com.busraciftlik.business.dto.responses.get.GetSaleResponse;
import com.busraciftlik.business.dto.responses.update.UpdateSaleResponse;
import com.busraciftlik.entities.Sale;
import com.busraciftlik.repository.abstracts.SaleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SaleManager implements SaleService {
    private final SaleRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllSalesResponse> getAll() {
        List<Sale> sales = repository.findAll();
        List<GetAllSalesResponse> responses = sales
                .stream().map(sale -> mapper.map(sale, GetAllSalesResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetSaleResponse getById(int id) {
        checkIfIdExists(id);
        Sale sale = repository.findById(id).orElseThrow();

        return mapper.map(sale, GetSaleResponse.class);
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request) {
        Sale sale = mapper.map(request, Sale.class);
        sale.setId(0);
        Sale savedSale = repository.save(sale);
        return mapper.map(savedSale, CreateSaleResponse.class);

    }

    @Override
    public UpdateSaleResponse update(int id, UpdateSaleRequest request) {
        checkIfIdExists(id);
        Sale sale = mapper.map(request, Sale.class);
        sale.setId(id);
        Sale saveSale = repository.save(sale);
        return mapper.map(saveSale, UpdateSaleResponse.class);

    }

    @Override
    public void delete(int id) {
        checkIfIdExists(id);
        repository.deleteById(id);
    }

    private void checkIfIdExists(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
    }
}
