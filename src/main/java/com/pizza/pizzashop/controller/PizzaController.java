package com.pizza.pizzashop.controller;

import com.pizza.pizzashop.entity.Pizza;
import com.pizza.pizzashop.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @PostMapping
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }



    // 1. Search Pizza by Name
    @GetMapping("/search")
    public List<Pizza> searchPizzas(@RequestParam String name) {
        return pizzaRepository.findByNameContaining(name);
    }

    // 2. Update Pizza (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable(value = "id") Long id, @RequestBody Pizza pizzaDetails) {
        return pizzaRepository.findById(id)
                .map(pizza -> {
                    pizza.setName(pizzaDetails.getName());
                    pizza.setPrice(pizzaDetails.getPrice());
                    pizza.setDescription(pizzaDetails.getDescription());
                    Pizza updatedPizza = pizzaRepository.save(pizza);
                    return ResponseEntity.ok(updatedPizza);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Delete Pizza (DELETE)
    @DeleteMapping("/{id}")
    public String deletePizza(@PathVariable Long id) {
        pizzaRepository.deleteById(id);
        return "Pizza deleted successfully with id: " + id;
    }
}