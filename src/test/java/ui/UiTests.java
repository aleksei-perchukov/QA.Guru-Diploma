package ui;

import api.TestBase;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ui.TestData.*;
import static ui.WebSteps.*;

public class UiTests extends TestBase {

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

    @Test
    @AllureId("12679")
    @DisplayName("Change website language to EN, then to RU")
    @Tags({@Tag("Desktop"), @Tag("Main"), @Tag("Settings"), @Tag("UI")})
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
    @DisplayName("Create user")
    @Tags({@Tag("User"), @Tag("Desktop"), @Tag("UI"), @Tag("UI")})
    @Owner("allure8")
    public void createUserTest() {

        openHomePage();
        String author = getTopAuthorName();
        clickTopAuthor();
        checkAllArticlesSameAuthor(author);
    }

    @Test
    @AllureId("12677")
    @DisplayName("Login aleksei.perchukov@gmail.com account")
    @Tags({@Tag("User"), @Tag("Desktop"), @Tag("UI"), @Tag("UI")})
    @Owner("allure8")
    public void loginTest() {
        openHomePage();
        clickAccountIconGuest();
        clickLogin();
        enterLogin(login);
        enterLoginPassword(loginPassword);
        clickLoginEnter();
        clickAccountIconUser();
        checkNickName(nickName);
    }

    @Test
    @AllureId("12675")
    @DisplayName("Quantity of search results is 20")
    @Tags({@Tag("Desktop"), @Tag("Search"), @Tag("UI")})
    @Owner("allure8")
    public void searchResultsQtyTest() {
        openHomePage();
        clickSearch();
        enterSearch("Test");
        clickPerformSearch();
        checkSearchArticlesQty(20);
    }

    @Test
    @AllureId("12674")
    @DisplayName("Search article 'Tutorial: Frontity — Setting Up Authorization for WordPress Private Endpoints'")
    @Tags({@Tag("Desktop"), @Tag("Search"), @Tag("UI")})
    @Owner("allure8")
    public void searchArticleTest() {
        openHomePage();
        clickSearch();
        enterSearch(searchArticle);
        clickPerformSearch();
        clickSearchArticle();
        checkSearchArticleName(searchArticle);
        checkSearchText(searchText);
    }
}
