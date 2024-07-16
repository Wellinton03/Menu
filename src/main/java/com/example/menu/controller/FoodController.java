package com.example.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.menu.food.Food;
import com.example.menu.food.FoodRepository;
import com.example.menu.food.FoodRequestDTO;
import com.example.menu.food.FoodResponseDTO;

@RestController
@RequestMapping("/food")
public class FoodController {
    
    @Autowired
    private FoodRepository repository;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList  = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
