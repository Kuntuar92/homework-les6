package homework.ls7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EotinishTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = ("https://eotinish.kz/");
    }


    @ParameterizedTest(name = "Поиск кнопки {1} на локали {0}")
    @CsvSource(value = {
            "kk, Менің өтініштерім",
            "ru, Мои обращения"
    })
    void checkTextInHeaderLocal(String locale, String buttons) {
        open(locale);
        $(by("data-test-id", "myAppealsBtn")).$(byText(buttons)).shouldBe(visible);
    }
}
