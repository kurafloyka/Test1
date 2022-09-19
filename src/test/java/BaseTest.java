import base.Base;
import base.BrowserInitializer;
import base.BrowserType;
import config.ConfigReader;
import config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Base {
    public BrowserType type;

    @BeforeEach
    public void setup() throws IOException {

        ConfigReader.populateSettings();
        BrowserInitializer.browserInitializer((BrowserType) Settings.browserType);

    }

    @AfterEach
    public void tearDown() {

        //webDriver.quit();

    }

}
