package resenkov.work.foodcloud;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 2, message = "Имя не должно быть короче 2 символов")
    private String name;

    @Size(min = 1, message = "Вы должны выбрать хотя бы один ингредиент")
    @ManyToMany()
    private List<Ingredient> ingredients =  new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

}
