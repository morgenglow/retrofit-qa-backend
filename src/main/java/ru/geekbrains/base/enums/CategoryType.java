package ru.geekbrains.base.enums;

import lombok.Getter;

public enum CategoryType {
    FOOD(1, "Food"),
    ELECTRONICS(2, "Electronics"),
    SOME (3, "SOME"),
    ZERO (3, "ZERO");

    @Getter
    private final Integer id;
    @Getter
    private final String title;

    CategoryType(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
