package tests.web;

import drivers.ConfigProvider;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    @Step("Browser configuration")
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

    @BeforeEach
    @Step("Adding Allure Listener")
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @AfterEach
    @Step("Adding Attachments to Allure report")
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
}