package com.busraciftlik.repository.abstracts;

import com.busraciftlik.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
