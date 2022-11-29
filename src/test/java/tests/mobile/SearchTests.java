package tests.mobile;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
@DisplayName("Mobile - Search Tests")
@Feature("Search")
public class SearchTests extends TestBase {
    @Test
    @AllureId("12691")
    @DisplayName("Search test header displaying in Search field after Search test query")
    @Tags({@Tag("Search"), @Tag("Mobile")})
    @Owner("allure8")
    @Severity(SeverityLevel.CRITICAL)
    void searchTest() {
        String searchtext = "Test";
        step("Click on Search button in header", () ->
                $$(AppiumBy.className("android.widget.Button")).get(1).click());
        step("Enter Test in search field", () ->
                $(AppiumBy.className("android.widget.EditText")).sendKeys("Test"));
        step("Click on Perform Search button", () ->
                $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText/android.view.View[1]")).click());
        Selenide.sleep(2000);
        step("Check that first articles name have word Test", () -> {
            String assertText = $$(AppiumBy.className("android.view.View")).get(5).getAttribute("content-desc");
            System.out.println(assertText);
            Assertions.assertTrue(assertText.contains("Test"));
        });
    }
}
