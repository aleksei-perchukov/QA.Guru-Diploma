package ui;

import api.config.ConfigProvider;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        ConfigProvider config = new ConfigProvider();
        config.setConfiguration();
        Configuration.baseUrl = "https://habr.com/ru/all/";

        if (ConfigProvider.isRemote) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }
    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        if ((Configuration.browser).equals("chrome")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        if (ConfigProvider.isRemote) {
            Attach.videoLocal();
        }
        WebDriverRunner.closeWebDriver();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All UI tests have been performed.");
    }
}