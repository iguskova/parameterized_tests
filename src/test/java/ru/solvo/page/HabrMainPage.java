package ru.solvo.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HabrMainPage {

    public HabrMainPage openMainPage() {
        open("https://habr.com/ru/all/");
        return this;
    }

    public HabrMainPage SearchForArticles(String input){
        $(".tm-header-user-menu__icon_search").click();
        $(".tm-input-text-decorated__input").setValue(input).pressEnter();
        return this;
    }

    public void checkResults(String input){
        $(".searched-item").shouldHave(text(input));

    }

    public HabrMainPage chooseTab(String tab){
        $$(byText(tab)).first().click();
        return this;
    }

    public void checkTab(String tab){
        $(".tm-section-name__text").shouldHave(text(tab));
    }

    public HabrMainPage clickItemWithNumber(int number){
        $(".tm-main-menu__item", number).click();
        return this;
    }
}
