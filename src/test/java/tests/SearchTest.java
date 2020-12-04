package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    @Test
    void searchGoogle() {
        open("https://www.google.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("html").shouldHave(Condition.text("selenide.org"));
    }
}
