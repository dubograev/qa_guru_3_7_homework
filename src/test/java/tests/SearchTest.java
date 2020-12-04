package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    @Test
    void searchGoogle() {
        open("https://www.google.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("html").shouldHave(text("selenide.org"));
    }

    @Test
    void searchYandex() {
        open("https://www.yandex.ru/");
        $("#text").setValue("Selenide").pressEnter();
        $(".serp-list").$$(".serp-item").shouldHaveSize(11);
        $(".serp-list").$$(".serp-item").get(0).shouldHave(text("Selenide"));
    }
}
