package tests.web.pageObjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Search {
    @Step("Click on \"Search\" button in the upper right corner")
    public void clickSearch() {
        $(".tm-header-user-menu__search").click();
    }

    @Step("Enter \"{search}\" in search field")
    public void enterSearch(String search) {
        $(".tm-input-text-decorated__input").sendKeys(search);
    }

    @Step("Click on \"Perform search\" button")
    public void clickPerformSearch() {
        $(".tm-search__icon").click();
    }

    @Step("Check that there are {qty} articles displayed")
    public void checkSearchArticlesQty(int qty) {
        $$(".tm-article-snippet").shouldHave(size(qty));
    }

    @Step("Check that \"{search}\" article is displayed")
    public void checkSearchArticleName(String search) {
        $(".tm-article-snippet__title.tm-article-snippet__title_h1").shouldHave(text(search));
    }

    @Step("Click on \"{search}\" article")
    public void clickSearchArticle() {
        $(".tm-article-snippet__title.tm-article-snippet__title_h2").click();
    }

    @Step("Check that \"{text}\" text is written at the end of the article")
    public void checkSearchText(String text) {
        $(byText(text)).should(exist);
    }

    @Step("Search")
    public void search(String searchText){
        clickSearch();
        enterSearch(searchText);
        clickPerformSearch();
        clickSearchArticle();
    }
}
