package tests.web.pageObjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homepage {
    @Step("Open homepage")
    public void openHomePage() {
        open("");
    }

    @Step("Click on \"language settings\" button in footer")
    public void clickLanguageSettingsButton() {
        $(".tm-footer__link").click();
    }

    @Step("Click on \"English\" interface button")
    public void clickEnglishInterfaceButton() {
        $$(".tm-input-radio-labeled__label").findBy(text("English")).click();
    }

    @Step("Click on \"Russian\" interface button")
    public void clickRussianInterfaceButton() {
        $$(".tm-input-radio-labeled__label").findBy(text("Русский")).click();
    }

    @Step("Click on \"Save settings\" button")
    public void clickSaveSettingsButton() {
        $(".tm-page-settings-form__submit.btn.btn_solid.btn_large").click();
    }

    @Step("Check English \"Articles\" menu header")
    public void checkEnglishMenuHeader() {
        $(byText("All streams")).scrollIntoView(true).shouldBe(visible);
    }

    @Step("Check Russian \"Articles\" menu header")
    public void checkRussianMenuHeader() {
        $(byText("Все потоки")).scrollIntoView(true).shouldBe(visible);
    }

    @Step("Get first top blog author name")
    public String getTopAuthorName() {
        String author = $$(".tm-companies-rating__name").first().getText();
        return author;
    }

    @Step("Click on first top blog author name")
    public void clickTopAuthor() {
        $$(".tm-companies-rating__name").first().click();
    }

    @Step("Check that all articles that are shown have {author} author")
    public void checkAllArticlesSameAuthor(String author) {
        $$(".tm-article-snippet").filter(text(author)).shouldHave(size(20));
    }
}
