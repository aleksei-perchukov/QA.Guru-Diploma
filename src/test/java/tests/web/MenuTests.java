package tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static tests.web.WebSteps.*;

public class MenuTests extends TestBase {
    @Test
    @AllureId("12678")
    @DisplayName("All Habr services menu appearance")
    @Tags({@Tag("Desktop"), @Tag("Menu"), @Tag("UI")})
    @Owner("allure8")
    public void habrServicesMenuTest() {
        openHomePage();
        clickHabrServicesList();
        checkServiceListOpened();
    }
}
