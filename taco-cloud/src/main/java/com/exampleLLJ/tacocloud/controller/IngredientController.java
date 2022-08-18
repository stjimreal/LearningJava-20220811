package com.exampleLLJ.tacocloud.controller;

import com.exampleLLJ.tacocloud.model.Ingredient;
import com.exampleLLJ.tacocloud.model.Taco;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Learning-20220811
 * @description:
 * @author: liuljing
 * @created: 2022/08/18 17:10
 */
@Slf4j
@RequestMapping("/design")
@Controller
public class IngredientController {
    @GetMapping
    public String list(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.FavorType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.FavorType.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.FavorType.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.FavorType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.FavorType.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.FavorType.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.FavorType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.FavorType.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.FavorType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.FavorType.SAUCE)
        );
        Ingredient.FavorType[] types = Ingredient.FavorType.values();
        for (Ingredient.FavorType type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());
        return "design";
    }

    // provided by 'aexiaosong'
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.FavorType type) {
        return ingredients.stream().filter(x -> x.getFavorType().equals(type)).collect(Collectors.toList());
    }
}
