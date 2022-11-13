package drivers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalMobileDriver implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        Config config = ConfigFactory.create(Config.class, System.getProperties());
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(config.getPlatformName());
        options.setDeviceName(config.getDevice());
        options.setPlatformVersion(config.getOsVersion());
        options.setApp(app.getAbsolutePath());
        options.setAppPackage(config.getAppPackage());
        options.setAppActivity(config.getAppActivity());
        options.setCapability("unicodeKeyboard", true);
        options.setCapability("resetKeyboard", true);

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApp() {
        String appPath = null;
        String appUrl = null;
        if (System.getProperty("device_host").equals("mobile-local")) {
            appPath = "src/test/resources/apps/app-armeabi-v7a-release.apk";
            appUrl = "https://drive.google.com/u/0/uc?id=1k3SwEybyvD_oWMGVNzNs2sDF73zSNlvs&export=download&confirm=t&uuid=86dc6339-f5b6-4eed-9478-27884dd2c611&at=ALAFpqz3RpE8d_Amy7XUscqgm0W5:1667768009833";
        } else if (System.getProperty("device_host").equals("mobile-real")) {
            appPath = "src/test/resources/apps/app-arm64-v8a-release.apk";
            appUrl = "https://drive.google.com/u/0/uc?id=1aAD4n2QQqQZVFPQZVJu0N3BT86QFsM16&export=download&confirm=t&uuid=7ece18cb-18e3-499e-b4b5-83e2d5b38f5b&at=ALAFpqx-GJOQdYZdmr7ftcrNguqc:1667773693470";
        }
        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }

}
