package drivers.mobile;

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
        String appPath = "src/test/resources/apps/Habar_1.7.0_Apkpure.apk";
        String appUrl = "https://d-04.winudf.com/b/APK/aW8uaGFiYXJfMThfYzdhYTM0ZTQ?_fn=SGFiYXJfMS43LjBfQXBrcHVyZS5hcGs&_p=aW8uaGFiYXI%3D&download_id=1304107437865261&is_hot=false&k=e4f2671ee6e5406d684cfb8e5bc0cdab63794310";
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
