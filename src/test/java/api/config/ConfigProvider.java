package api.config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static String isRemote = "false";

    public ConfigProvider setConfiguration() {
        Config config = ConfigFactory.create(Config.class, System.getProperties());
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        RestAssured.baseURI = config.getBaseURI();
        Configuration.remote = config.getRemoteUrl();
        isRemote = config.getIsRemote();
        return this;
    }
}
