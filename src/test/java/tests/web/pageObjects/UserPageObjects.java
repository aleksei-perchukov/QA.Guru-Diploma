package tests.web.pageObjects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static tests.web.WebTestData.login;
import static tests.web.WebTestData.loginPassword;

public class UserPageObjects {
    @Step("Click on Account icon at the upper right corner (Guest)")
    public void clickAccountIconGuest() {
        $$(".tm-dropdown").get(1).click();
    }

    @Step("Click on Account icon at the upper right corner (User)")
    public void clickAccountIconUser() {
        $$(".tm-dropdown").get(2).click();
    }

    @Step("Click on \"Login\" button")
    public void clickLogin() {
        $(".tm-user-menu__auth-button").click();
    }

    @Step("Enter \"{login}\" in \"E-mail\" field")
    public void enterLogin(String login) {
        $("#email_field").setValue(login);
    }

    @Step("Enter \"{appassword}\" in \"Password\" field")
    public void enterLoginPassword(String appassword) {
        $("#password_field").setValue(appassword);
    }

    @Step("Check \"{userName}\" nickname is displayed in menu")
    public void checkNickName(String nickName) {
        $(".tm-user-item__username").shouldHave(text(nickName));
    }

    @Step("Click on \"Enter\" button")
    public void clickLoginEnter() {
        $(".button.button_wide.button_primary").click();
    }

    @Step("Login")
    public void login(){
        clickLogin();
        enterLogin(login);
        enterLoginPassword(loginPassword);
        clickLoginEnter();
    }

}
