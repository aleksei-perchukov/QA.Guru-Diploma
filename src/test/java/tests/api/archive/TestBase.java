package tests.api.archive;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.ConfigProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.restassured.RestAssured.baseURI;

public class TestBase {
    @BeforeAll
    static void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        ConfigProvider config = new ConfigProvider();
        config.setConfiguration();
        baseURI = "https://habr.com/ru";
        if (ConfigProvider.isRemote.equals("true")) {
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
//        Attach.screenshotAs("Screenshot");
//        if ((Configuration.browser).equals("chrome")) {
//            Attach.pageSource();
//            Attach.browserConsoleLogs();
//        }
//        if (ConfigProvider.isRemote.equals("true")) {
//            Attach.videoLocal();
//        }
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All API tests have been performed.");
    }
}