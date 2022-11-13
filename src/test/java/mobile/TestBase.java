package mobile;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    @BeforeAll
    @Step("Start mobile driver")
    public static void setup() {
        String host = System.getProperty("device_host");
        if (System.getProperty("device_host").equals("mobile-browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else if (System.getProperty("device_host").equals("mobile-local")
        || System.getProperty("device_host").equals("mobile-real")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    @Step("Allure setup")
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    @Step("Adding attachments")
    public void afterEach() {
        String sessionId = sessionId().toString();
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        closeWebDriver();
        if (System.getProperty("device_host").equals("mobile-browserstack"))
        {Attach.videoBrowserStack(sessionId);}
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All mobile tests have been performed.");
    }
}
