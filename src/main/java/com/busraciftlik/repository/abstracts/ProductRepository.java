package com.busraciftlik.repository.abstracts;

import com.busraciftlik.entities.Product;
import com.busraciftlik.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    //List<Product> findAllByPriceBetweenAndQuantityGreaterThan(double a,double b,int x);
    List<Product> findAllByStatus(Status status);
}
