package com.busraciftlik.business.concretes;

import com.busraciftlik.entities.Category;
import com.busraciftlik.entities.Product;
import com.busraciftlik.entities.enums.Status;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class JPAManager {
    private final EntityManager entityManager;

    public void testJpa() {
        Product product = entityManager.find(Product.class, 1);
        String s = product.toString();
        System.out.println(s);
    }

    @Transactional
    public void saveProductTest() {
        Category category = entityManager.find(Category.class, 1);
        Product product = new Product(0, "test", 20, 250, "test", Status.ACTIVE,Collections.singleton(category));
        entityManager.persist(product);
    }

    public void queryProductTestJpql() {
        TypedQuery<Product> selectPFromProductP = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> resultList = selectPFromProductP.getResultList();

    }

}
