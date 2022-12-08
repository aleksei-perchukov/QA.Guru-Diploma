package tests.mobile.tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.mobile.BaseMobileTest;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@DisplayName("Mobile - Main Tests")
@Feature("Main")
public class MainTests extends BaseMobileTest {
    @Test
    @AllureId("12830")
    @DisplayName("Save article")
    @Tags({@Tag("Main"), @Tag("Mobile"), @Tag("Settings")})
    @Owner("allure8")
    @Severity(SeverityLevel.NORMAL)
    void mobileSaveArticle() {
        step("Click on Saved Articles button in footer", () ->
                $(AppiumBy.accessibilityId("Сохраненные\n" + "Tab 4 of 4")).click());
        step("Check There are no saved articles text", () ->
                $(AppiumBy.accessibilityId("Вы пока ничего не сохранили")).shouldBe(visible));
        step("Click on Articles button in footer", () ->
                $(AppiumBy.accessibilityId("Статьи\n" + "Tab 1 of 4")).click());
        step("Click on Save Article button on the first article", () ->
                $$(AppiumBy.className("android.widget.Button")).get(4).click());
        step("Click on Saved Articles button in footer", () ->
                $(AppiumBy.accessibilityId("Сохраненные\n" + "Tab 4 of 4")).click());
        step("Check article appeared in Saved Articles menu", () -> {
            $$(AppiumBy.className("android.widget.Button")).shouldHave(size(6));
        });
    }
}
