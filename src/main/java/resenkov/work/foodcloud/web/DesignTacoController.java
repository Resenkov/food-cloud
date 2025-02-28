package resenkov.work.foodcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import resenkov.work.foodcloud.Ingredient;
import resenkov.work.foodcloud.Ingredient.Type;
import resenkov.work.foodcloud.Taco;
import resenkov.work.foodcloud.TacoOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("МУЛП", "Мучная лепешка", Type.WRAP),
                new Ingredient("КУКУ", "Кукурузная лепешка", Type.WRAP),
                new Ingredient("ГВФШ", "Говяжий фарш", Type.PROTEIN),
                new Ingredient("СВФШ", "Свиной фарш", Type.PROTEIN),
                new Ingredient("ПИДР", "Помидоры", Type.VEGGIES),
                new Ingredient("СЛАТ", "Салат", Type.VEGGIES),
                new Ingredient("ЧЕДР", "Чеддр", Type.CHEESE),
                new Ingredient("РОСС", "Российский", Type.CHEESE),
                new Ingredient("СЛСА", "Сальса", Type.SAUCE),
                new Ingredient("СМТН", "Сметана", Type.SAUCE)
        );


        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }


    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }


    @PostMapping
    public  String processTaco (Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Taco: " + taco);

        return "redirect:/orders/current";
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }


    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}