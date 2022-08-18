package com.exampleLLJ.tacocloud.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @program: Learning-20220811
 * @description:
 * @author: liuljing
 * @created: 2022/08/18 17:08
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final FavorType favorType;

    public enum FavorType {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}