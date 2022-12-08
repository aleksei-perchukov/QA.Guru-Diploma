package tests.web.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.web.BaseWebTest;
import tests.web.pageObjects.MainPageObjects;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("Desktop"), @Tag("Main"), @Tag("WEB")})
@Owner("allure8")
@DisplayName("WEB - Main tests")
public class MainTests extends BaseWebTest {
    MainPageObjects mainPageObjects = new MainPageObjects();

    @Test
    @AllureId("12679")
    @DisplayName("Change website language to EN")
    @Tag("Settings")
    public void changeLanguageEnTest() {
        mainPageObjects.openHomePage();
        step("Check EN language", () -> {
            mainPageObjects.clickLanguageSettingsButton();
            mainPageObjects.clickEnglishInterfaceButton();
            mainPageObjects.clickSaveSettingsButton();
            mainPageObjects.checkEnglishMenuHeader();
        });
    }

    @Test
    @AllureId("13568")
    @DisplayName("Change website language to RU")
    @Tag("Settings")
    public void changeLanguageRuTest(){
        step("Check RU language", () -> {
            mainPageObjects.clickLanguageSettingsButton();
            mainPageObjects.clickRussianInterfaceButton();
            mainPageObjects.clickSaveSettingsButton();
            mainPageObjects.checkRussianMenuHeader();
        });
    }

    @Test
    @AllureId("12676")
    @DisplayName("Clicking on author shows posts with his articles")
    public void createUserTest() {
        mainPageObjects.openHomePage();
        String author = mainPageObjects.getTopAuthorName();
        mainPageObjects.clickTopAuthor();
        mainPageObjects.checkAllArticlesSameAuthor(author);
    }
}