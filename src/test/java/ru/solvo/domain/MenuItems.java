package ru.solvo.domain;

public enum MenuItems {
    ALL_TOPICS("Все потоки"),
    DEVELOPMENT("Разработка"),
    ADMINISTRATION("Администрирование"),
    DESIGN("Дизайн"),
    MANAGEMENT("Менеджмент"),
    MARKETING("Маркетинг"),
    POPULAR_SCIENCE("Научпоп");


    private String description;

    MenuItems(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}