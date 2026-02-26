package com.pizza.pizzashop.repository;

import com.pizza.pizzashop.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}