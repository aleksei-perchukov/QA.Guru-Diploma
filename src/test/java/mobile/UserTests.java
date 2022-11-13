package mobile;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

@Tag("Mobile")
@Feature("User tests")
public class UserTests {

    @Test
    @AllureId("12673")
    @DisplayName("Search header appearing check")
    void searchTest() {
        $(AppiumBy.accessibilityId("Search")).click();
        $(AppiumBy.className("android.widget.EditText")).sendKeys("test");
        $(AppiumBy.accessibilityId("Поиск")).click();
        $(AppiumBy.accessibilityId("Search test")).exists();
    }
}