package resenkov.work.foodcloud.web;

import org.springframework.stereotype.Component;
import resenkov.work.foodcloud.Ingredient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import resenkov.work.foodcloud.Ingredient.Type;
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("МУЛП",
                new Ingredient("МУЛП", "Мучная лепешка", Type.WRAP));
        ingredientMap.put("КУКУ",
                new Ingredient("КУКУ", "Кукурузная лепешка", Type.WRAP));
        ingredientMap.put("ГВФШ",
                new Ingredient("ГВФШ", "Говяжий фарш", Type.PROTEIN));
        ingredientMap.put("СВФШ",
                new Ingredient("СВФШ", "Свиной фарш", Type.PROTEIN));
        ingredientMap.put("ПИДР",
                new Ingredient("ПИДР", "Помидоры", Type.VEGGIES));
        ingredientMap.put("СЛАТ",
                new Ingredient("СЛАТ", "Салат", Type.VEGGIES));
        ingredientMap.put("ЧЕДР",
                new Ingredient("ЧЕДР", "Чеддр", Type.CHEESE));
        ingredientMap.put("РОСС",
                new Ingredient("РОСС", "Российский", Type.CHEESE));
        ingredientMap.put("СЛСА",
                new Ingredient("СЛСА", "Сальса", Type.SAUCE));
        ingredientMap.put("СМТН",
                new Ingredient("СМТН", "Сметана", Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }

}
