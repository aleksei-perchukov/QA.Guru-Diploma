package tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static tests.web.TestData.*;
import static tests.web.WebSteps.*;

@DisplayName("WEB - User tests")
public class UserTests extends TestBase {

    @Test
    @AllureId("12677")
    @DisplayName("Login aleksei.perchukov@gmail.com account")
    @Tags({@Tag("User"), @Tag("Desktop"), @Tag("WEB")})
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
}
