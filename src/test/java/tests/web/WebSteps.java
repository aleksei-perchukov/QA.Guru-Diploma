package tests.web;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {
    @Step("Open homepage")
    static void openHomePage() {
        open("");
    }

    @Step("Click on \"Open Habr services list\" to the right of Habr main logo")
    static void clickHabrServicesList() {
        $(".tm-header__dropdown-toggle").click();
    }

    @Step("Check that menu is opened")
    static void checkServiceListOpened(){
        $(".tm-our-projects").should(exist);
    }

    @Step("Click on \"language settings\" button in footer")
    static void clickLanguageSettingsButton() {
        $(".tm-footer__link").click();
    }

    @Step("Click on \"English\" interface button")
    static void clickEnglishInterfaceButton() {
        $$(".tm-input-radio-labeled__label").findBy(text("English")).click();
    }

    @Step("Click on \"Russian\" interface button")
    static void clickRussianInterfaceButton() {
        $$(".tm-input-radio-labeled__label").findBy(text("Русский")).click();
    }

    @Step("Click on \"Save settings\" button")
    static void clickSaveSettingsButton() {
        $(".tm-page-settings-form__submit.btn.btn_solid.btn_large").click();
    }

    //ASSERTS
    @Step("Check English logo")
    static void checkEnglishLogo() {
        $("[*='/img/habr-logo-en.svg#logo']").scrollIntoView(true).shouldHave();
    }

    @Step("Check English \"Articles\" menu header")
    static void checkEnglishMenuHeader() {
        $(byText("All streams")).scrollIntoView(true).should(exist);
    }

    @Step("Check Russian logo")
    static void checkRussianLogo() {
        $("[*='/img/habr-logo-ru.svg#logo']").scrollIntoView(true).shouldHave();
    }

    @Step("Check Russian \"Articles\" menu header")
    static void checkRussianMenuHeader() {
        $(byText("Все потоки")).scrollIntoView(true).should(exist);
    }

    @Step("Click on Account icon at the upper right corner (Guest)")
    static void clickAccountIconGuest(){
        $$(".tm-dropdown").get(1).click();
    }
    @Step("Click on Account icon at the upper right corner (User)")

    static void clickAccountIconUser(){
        $$(".tm-dropdown").get(2).click();
    }

    @Step("Open \"create user\" page")
    static void openCreateUserPage() {
        open("https://account.habr.com/register/");
    }

    @Step("Click on \"Register\" button")
    static void clickRegisterButton() {
        $(".tm-user-menu__auth-button.tm-user-menu__auth-button_primary").click();
    }

    @Step("Enter {email} in e-mail field")
    static void registerSetEmail(String email) {
        $("#email_field").setValue(email);

    }

    @Step("Enter {firstName}_{lastName} in \"Nickname\" field")
    static void registerSetNickname(String firstName, String lastName) {
        $("#nickname_field").setValue(firstName + "_" + lastName);
    }

    @Step("Enter {password} in \"Password\" field")
    static void registerSetPassword(String password) {
        $("#password_field").setValue(password);

    }

    @Step("Enter {password} in \"Password\" field")
    static void registerSetConfirmPassword(String password) {
        $("#password_repeat").setValue(password);
    }

    @Step("Click on \"Recaptcha\" checkbox")
    static void registerRecaptchaClick() {
        $(".recaptcha-checkbox").click();
    }

    @Step("Click on \"Register\" button")
    static void registerClickRegister() {
        $("#registration_button").click();
    }

    @Step("Check \"Accept email\" text is displayed on the page")
    static void checkAcceptEmail() {
        $(".shadow-box__title").shouldHave(text("Подтвердите почту"));
    }

    @Step("Check {email} is displayed on the page")
    static void checkEmailDisplay(String email) {
        $(".shadow-box__email").shouldHave(text(email));
    }

    @Step("Click on \"Login\" button")
    static void clickLogin() {
        $(".tm-user-menu__auth-button").click();
    }

    @Step("Enter \"{login}\" in \"E-mail\" field")
    static void enterLogin(String login) {
        $("#email_field").setValue(login);
    }

    @Step("Enter \"{appassword}\" in \"Password\" field")
    static void enterLoginPassword(String appassword) {
        $("#password_field").setValue(appassword);
    }

    @Step("Click on \"Enter\" button")
    static void clickLoginEnter() {
        $(".button.button_wide.button_primary").click();
    }

    @Step("Click on \"Search\" button in the upper right corner")
    static void clickSearch() {
        $(".tm-header-user-menu__search").click();
    }


    @Step("Enter \"{search}\" in search field")
    static void enterSearch(String search) {
        $(".tm-input-text-decorated__input").sendKeys(search);
    }

    @Step("Click on \"Perform search\" button")
    static void clickPerformSearch() {
        $(".tm-search__icon").click();
    }

    @Step("Check \"{userName}\" nickname is displayed in menu")
    static void checkNickName(String nickName) {
        $(".tm-user-item__username").shouldHave(text(nickName));
    }

    @Step("Check that there are {qty} articles displayed")
    static void checkSearchArticlesQty(int qty) {
        $$(".tm-article-snippet").shouldHave(size(qty));
    }

    @Step("Check that \"{search}\" article is displayed")
    static void checkSearchArticleName(String search) {
        $(".tm-article-snippet__title.tm-article-snippet__title_h1").shouldHave(text(search));
    }

    @Step("Click on \"{search}\" article")
    static void clickSearchArticle() {
        $(".tm-article-snippet__title.tm-article-snippet__title_h2").click();
    }

    @Step("Check that \"{text}\" text is written at the end of the article")
    static void checkSearchText(String text) {
        $(byText(text)).should(exist);

    }
    @Step("Get first top blog author name")
    static String getTopAuthorName(){
        String author = $$(".tm-companies-rating__name").first().getText();
        return author;
    }

    @Step("Click on first top blog author name")
    static void clickTopAuthor(){
        $$(".tm-companies-rating__name").first().click();
    }

    @Step("Check that all articles that are shown have {author} author")
    static void checkAllArticlesSameAuthor(String author) {
        $$(".tm-article-snippet").filter(text(author)).shouldHave(size(20));
    }

}
