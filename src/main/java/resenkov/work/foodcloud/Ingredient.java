package resenkov.work.foodcloud;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Cacheable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)

public class Ingredient {

    @Id
    private String id;
    private String name;
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}