package com.pizza.pizzashop.repository;

import com.pizza.pizzashop.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    // Ye method apne aap SQL query generate karega
    List<Pizza> findByNameContaining(String name);
}