package com.pizza.pizzashop.controller;

import com.pizza.pizzashop.entity.Pizza;
import com.pizza.pizzashop.repository.PizzaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    // 1️⃣ Add Pizza (POST)
    @PostMapping
    public Pizza addPizza(@RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    // 2️⃣ Get All Pizzas (GET)
    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    // 3️⃣ Update Pizza (PUT)
    @PutMapping("/{id}")
    public Pizza updatePizza(@PathVariable Long id, @RequestBody Pizza updatedPizza) {

        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));

        pizza.setName(updatedPizza.getName());
        pizza.setPrice(updatedPizza.getPrice());
        pizza.setSize(updatedPizza.getSize());

        return pizzaRepository.save(pizza);
    }


    // 4️⃣ Delete Pizza
    @DeleteMapping("/{id}")
    public String deletePizza(@PathVariable Long id) {

        if (!pizzaRepository.existsById(id)) {
            throw new RuntimeException("Pizza not found");
        }

        pizzaRepository.deleteById(id);
        return "Pizza deleted successfully!";
    }
}
