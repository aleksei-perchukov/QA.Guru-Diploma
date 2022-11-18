package tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static tests.web.TestData.searchArticle;
import static tests.web.TestData.searchText;
import static tests.web.WebSteps.*;

public class SearchTests extends TestBase {
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
}
