package com.example.menu.food;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "foods")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    private String title;

    private String image;

    private Integer price;

    public Food(FoodRequestDTO data) {
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }
}