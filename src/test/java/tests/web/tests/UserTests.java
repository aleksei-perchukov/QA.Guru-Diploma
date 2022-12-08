package tests.web.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.web.BaseWebTest;
import tests.web.pageObjects.MainPageObjects;
import tests.web.pageObjects.UserPageObjects;

import static tests.web.WebTestData.nickName;

@Tags({@Tag("User"), @Tag("Desktop"), @Tag("WEB")})
@Owner("allure8")
@DisplayName("WEB - User tests")
public class UserTests extends BaseWebTest {

    MainPageObjects mainPageObjects = new MainPageObjects();
    UserPageObjects userPageObjects = new UserPageObjects();

    @Test
    @AllureId("12677")
    @DisplayName("Login aleksei.perchukov@gmail.com account")
    public void loginTest() {
        mainPageObjects.openHomePage();
        userPageObjects.clickAccountIconGuest();
        userPageObjects.login();
        userPageObjects.clickAccountIconUser();
        userPageObjects.checkNickName(nickName);
    }
}
