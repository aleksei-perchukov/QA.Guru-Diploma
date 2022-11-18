package tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.web.WebSteps.*;

public class MainTests extends TestBase {
    @Test
    @AllureId("12679")
    @DisplayName("Change website language to EN, then to RU")
    @Tags({@Tag("Desktop"), @Tag("Main"), @Tag("Settings"), @Tag("WEB")})
    @Owner("allure8")
    public void changeLanguagesTest() {
        openHomePage();
        step("Check EN language", () -> {
            clickLanguageSettingsButton();
            clickEnglishInterfaceButton();
            clickSaveSettingsButton();
            checkEnglishMenuHeader();
        });
        step("Check RU language", () -> {
            clickLanguageSettingsButton();
            clickRussianInterfaceButton();
            clickSaveSettingsButton();
            checkRussianMenuHeader();
        });
    }

    @Test
    @AllureId("12676")
    @DisplayName("Clicking on author shows posts with his articles")
    @Tags({@Tag("Main"), @Tag("Desktop"), @Tag("UI"), @Tag("WEB")})
    @Owner("allure8")
    public void createUserTest() {
        openHomePage();
        String author = getTopAuthorName();
        clickTopAuthor();
        checkAllArticlesSameAuthor(author);
    }
}