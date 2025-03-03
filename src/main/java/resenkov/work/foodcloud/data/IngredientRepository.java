package resenkov.work.foodcloud.data;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import resenkov.work.foodcloud.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {


}
