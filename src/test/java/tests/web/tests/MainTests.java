package tests.web.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.web.BaseWebTest;
import tests.web.pageObjects.Homepage;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("Desktop"), @Tag("Main"), @Tag("WEB")})
@Owner("allure8")
@DisplayName("WEB - Main tests")
public class MainTests extends BaseWebTest {
    Homepage homepage = new Homepage();

    @Test
    @AllureId("12679")
    @DisplayName("Change website language to EN")
    @Tag("Settings")
    public void changeLanguageEnTest() {
        homepage.openHomePage();
        step("Check EN language", () -> {
            homepage.clickLanguageSettingsButton();
            homepage.clickEnglishInterfaceButton();
            homepage.clickSaveSettingsButton();
            homepage.checkEnglishMenuHeader();
        });
    }

    @Test
    @AllureId("13568")
    @DisplayName("Change website language to RU")
    @Tag("Settings")
    public void changeLanguageRuTest(){
        homepage.openHomePage();
        step("Check RU language", () -> {
            homepage.clickLanguageSettingsButton();
            homepage.clickRussianInterfaceButton();
            homepage.clickSaveSettingsButton();
            homepage.checkRussianMenuHeader();
        });
    }

    @Test
    @AllureId("12676")
    @DisplayName("Clicking on author shows posts with his articles")
    public void createUserTest() {
        homepage.openHomePage();
        String author = homepage.getTopAuthorName();
        homepage.clickTopAuthor();
        homepage.checkAllArticlesSameAuthor(author);
    }
}