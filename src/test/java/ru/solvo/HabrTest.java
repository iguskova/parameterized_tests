package ru.solvo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.solvo.domain.MenuItems;
import ru.solvo.page.HabrMainPage;

import java.util.stream.Stream;

public class HabrTest {

    private HabrMainPage page = new HabrMainPage();

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        0, " Все потоки"
                ),
                Arguments.of(
                        1, "Разработка"
                ),
                Arguments.of(
                        2, "Администрирование"
                ),
                Arguments.of(
                        3, "Дизайн"
                ),
                Arguments.of(
                        4, "Менеджмент"
                ),
                Arguments.of(
                        5, "Маркетинг"
                ),
                Arguments.of(
                        6, "Научпоп"
                )
        );
    }

    @CsvSource({
            "java",
            "python"
    })

    @ParameterizedTest()
    @DisplayName("Search using csv source")
    void searchUsingCsvSource(String input){
        page.openMainPage()
                .SearchForArticles(input)
                .checkResults(input);
    }

    @EnumSource (value = MenuItems.class)

    @ParameterizedTest()
    @DisplayName("Open tabs using enum source")
    void openTabsUsingEnumSource(MenuItems menuItems){
        page.openMainPage()
                .chooseTab(menuItems.getDescription())
                .checkTab(menuItems.getDescription());
    }

    @MethodSource("testWithMethodSource")

    @ParameterizedTest()
    @DisplayName("Open tabs using method source")
    void openTabsUsingMethodSource(int number, String tab){
        page.openMainPage()
                .clickItemWithNumber(number)
                .checkTab(tab);
    }
}
