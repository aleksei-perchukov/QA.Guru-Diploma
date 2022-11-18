package drivers.mobile;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    public static boolean isRemote = false;
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        Config configBS = ConfigFactory.create(Config.class, System.getProperties());
        mutableCapabilities.setCapability("browserstack.user", configBS.getBrowserstackUser());
        mutableCapabilities.setCapability("browserstack.key", configBS.getBrowserstackKey());
        mutableCapabilities.setCapability("appUrl", configBS.getAppUrl());
        mutableCapabilities.setCapability("device", configBS.getDevice());
        mutableCapabilities.setCapability("os_version", configBS.getOsVersion());
        mutableCapabilities.setCapability("project", configBS.getProject());
        mutableCapabilities.setCapability("device", configBS.getDevice());
        mutableCapabilities.setCapability("os_version", configBS.getOsVersion());
        mutableCapabilities.setCapability("remoteUrl", configBS.getRemoteUrl());
        mutableCapabilities.setCapability("build", configBS.getBuild());
        mutableCapabilities.setCapability("name", configBS.getName());
        mutableCapabilities.setCapability("unicodeKeyboard", "true");
        mutableCapabilities.setCapability("resetKeyboard", "true");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
