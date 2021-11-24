package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static config.Project.config;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class Tests extends TestBase {

    @Test
    @DisplayName("Letual tests")
    void changeCityTest(){

        step("Open main page " + config.webURL(), () -> {
            open(config.webURL());
        });
        Actions builder = new Actions(webdriver().object());
        SelenideElement popup = $(".guess-city-popup");
        SelenideElement selenideElement = popup.$$("button").get(1);
        builder.moveToElement(selenideElement.getWrappedElement()).click().build().perform();
        sleep(10000);
    //    SelenideElement popup = $(".guess-city-popup");//.shouldBe(Condition.visible);
        $(popup).$(withText("Изменить город")).click();
        sleep(5000);
        $(".letu-modal-title").shouldBe(Condition.visible);
        $$("li.city-selector-item").find(Condition.text("Самара")).click();
        sleep(5000);
        SelenideElement samara = $("header").$(byText("Город доставки")).sibling(0);
        assertThat(samara).isEqualTo("Самара");
    }

    @Test
    @DisplayName("Letual tests")
    void selectFromCatalogTest(){

        step("Open main page " + config.webURL(), () -> {
            open(config.webURL());
        });

        $("input[type=search]").setValue("chanel").pressEnter();
        sleep(5000);
   //    $("button.main-menu-rd-catalog-btn").click();
    }

}
