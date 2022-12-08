package tests.web.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.web.BaseWebTest;
import tests.web.pageObjects.MainPageObjects;
import tests.web.pageObjects.SearchPageObjects;

import static tests.web.WebTestData.searchArticle;
import static tests.web.WebTestData.searchText;

@Tags({@Tag("Desktop"), @Tag("Search"), @Tag("WEB")})
@Owner("allure8")
@DisplayName("WEB - Search tests")
public class SearchTests extends BaseWebTest {
    MainPageObjects mainPageObjects = new MainPageObjects();
    SearchPageObjects searchPageObjects = new SearchPageObjects();

    @Test
    @AllureId("12674")
    @DisplayName("Search article 'Tutorial: Frontity — Setting Up Authorization for WordPress Private Endpoints'")
    public void searchArticleTest() {
        mainPageObjects.openHomePage();
        searchPageObjects.search(searchArticle);
        searchPageObjects.checkSearchArticleName(searchArticle);
        searchPageObjects.checkSearchText(searchText);
    }

    @Test
    @AllureId("12675")
    @DisplayName("Quantity of search results is 20")
    public void searchResultsQtyTest() {
        mainPageObjects.openHomePage();
        searchPageObjects.search("Test");
        searchPageObjects.checkSearchArticlesQty(20);
    }
}
