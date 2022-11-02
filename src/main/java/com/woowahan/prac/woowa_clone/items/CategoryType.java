package com.woowahan.prac.woowa_clone.items;

public enum CategoryType {
    KOREAN, AMERICAN, JAPANESE, CHINESE, DESSERT;

    public static CategoryType toCategoryType(String category) {
        return CategoryType.valueOf(category);
    }
}
