package tests.web;

import drivers.ConfigProvider;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @DisplayName("Browser configuration")
    @BeforeAll
    static void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        ConfigProvider config = new ConfigProvider();
        config.setConfiguration();
        Configuration.baseUrl = "https://habr.com/ru/all/";

        if (ConfigProvider.isRemote.equals("true")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }
    @DisplayName("Adding Allure Listener (Configuration)")
    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @DisplayName("Adding Attachments to Allure report")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        if ((Configuration.browser).equals("chrome")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        if (ConfigProvider.isRemote.equals("true")) {
            Attach.videoLocal();
        }
        WebDriverRunner.closeWebDriver();
    }

    @DisplayName("Finished!")
    @AfterAll
    static void afterAll() {
        System.out.println("All web tests have been performed.");
    }
}