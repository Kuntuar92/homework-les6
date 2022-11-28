package homework.ls7;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class KolesaWebTest {

    static Stream<Arguments> kolesaTest() {

        return Stream.of(
                Arguments.of("Легковые", List.of(
                        "Год выпуска",
                        "Цена",
                        "Купить в кредит",
                        "Первоначальный взнос",
                        "Ежемесячный платеж")),

                Arguments.of("Мототехника",  List.of(
                        "Год выпуска",
                        "Цена"))
        );
    }
    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("https://kolesa.kz");
    }

    @MethodSource
    @ParameterizedTest(name = "Найти в фильтре {0} поля {1}")
    @Tag("MEDIUM")

    void kolesaTest(String searchForm, List <String> filters) {
        $(".action-list").$(byText(searchForm)).click();
        $$(".secondary>.element-group").filter(visible).shouldHave(CollectionCondition.texts(filters));

    }
}
