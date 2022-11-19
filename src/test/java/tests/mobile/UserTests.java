package tests.mobile;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Feature("Search tests")
@DisplayName("Mobile - User Tests")
public class UserTests extends TestBase {

    @Test
    @AllureId("12831")
    @DisplayName("Check article commentaries menu")
    @Tags({@Tag("User"), @Tag("Mobile")})
    @Owner("allure8")
    @Severity(SeverityLevel.NORMAL)
    void mobileCommentariesTest() {
        step("Click on Comments button on first article", () ->
                $$(AppiumBy.className("android.widget.Button")).get(6).click());
        step("Check Comments header", () ->
                $(AppiumBy.accessibilityId("Комментарии")).should(exist));
    }

    @Test
    @AllureId("12832")
    @DisplayName("Check username in User Profile menu")
    @Tags({@Tag("User"), @Tag("Mobile")})
    @Owner("allure8")
    @Severity(SeverityLevel.NORMAL)
    void mobileUsernameProfileTest() {
        String userName = $$(AppiumBy.className("android.widget.ImageView")).first().getAttribute("content-desc");
        step("Click on the first article authors name", () -> {
            $$(AppiumBy.className("android.widget.ImageView")).first().click();
        });
        step("Check authors nickname in menu", () -> {
            $(AppiumBy.accessibilityId(userName)).shouldBe(exist);
        });
    }

}

