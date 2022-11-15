package mobile;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
@Disabled
@Tag("Mobile")
@Feature("Search tests")
public class SearchTests extends TestBase {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search header appearing check")
    void searchTest() {

    }
}
