package tests.web.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.web.BaseWebTest;
import tests.web.pageObjects.Homepage;
import tests.web.pageObjects.Menu;

@Tags({@Tag("Desktop"), @Tag("Menu"), @Tag("WEB")})
@Owner("allure8")
@DisplayName("WEB - Menu tests")
public class MenuTests extends BaseWebTest {
    Homepage homepage = new Homepage();
    Menu menu = new Menu();

    @Test
    @AllureId("12678")
    @DisplayName("All Habr services menu appearance")
    public void habrServicesMenuTest() {
        homepage.openHomePage();
        menu.clickHabrServicesList();
        menu.checkServiceListOpened();
    }
}
