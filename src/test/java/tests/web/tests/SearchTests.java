package tests.web.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.web.BaseWebTest;
import tests.web.pageObjects.Homepage;
import tests.web.pageObjects.Search;

import static tests.web.WebTestData.searchArticle;
import static tests.web.WebTestData.searchText;

@Tags({@Tag("Desktop"), @Tag("Search"), @Tag("WEB")})
@Owner("allure8")
@DisplayName("WEB - Search tests")
public class SearchTests extends BaseWebTest {
    Homepage homepage = new Homepage();
    Search search = new Search();

    @Test
    @AllureId("12674")
    @DisplayName("Search article 'Tutorial: Frontity — Setting Up Authorization for WordPress Private Endpoints'")
    public void searchArticleTest() {
        homepage.openHomePage();
        search.search(searchArticle);
        search.checkSearchArticleName(searchArticle);
        search.checkSearchText(searchText);
    }

    @Test
    @AllureId("12675")
    @DisplayName("Quantity of search results is 20")
    public void searchResultsQtyTest() {
        homepage.openHomePage();
        search.search("Test");
        search.checkSearchArticlesQty(20);
    }
}
