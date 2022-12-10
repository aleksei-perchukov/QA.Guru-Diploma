package tests.web.pageObjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Menu {

    @Step("Click on \"Open Habr services list\" to the right of Habr main logo")

    public void clickHabrServicesList() {
        $(".tm-header__dropdown-toggle").click();
    }

    @Step("Check that menu is opened")
    public void checkServiceListOpened() {
        $(".tm-our-projects").shouldBe(visible);
    }
}
