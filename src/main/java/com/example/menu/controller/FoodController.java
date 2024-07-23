package com.example.menu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Long saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        
        Food saveFood = repository.save(foodData);
        return saveFood.getId();
    }
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList  = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodRequestDTO> updateFood(@PathVariable Long id, @RequestBody FoodRequestDTO foodRequestDTO) {
        
        Optional<Food> optionalFood = repository.findById(id);

        if (optionalFood.isPresent()) {
            Food food = optionalFood.get();

            food.setTitle(foodRequestDTO.title());
            food.setPrice(foodRequestDTO.price());
            food.setImage(foodRequestDTO.image());

            Food updateFood = repository.save(food);

            FoodRequestDTO dto = toDTO(updateFood);
            
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
            if ( repository.existsById(id)) {
                repository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    private FoodRequestDTO toDTO(Food food) {
        return new FoodRequestDTO(food.getTitle(), food.getImage(),food.getPrice());
    }
}
