import base.Base;
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





       //BrowserInitializer.browserInitializer((BrowserType) Settings.browserType);
        type = (BrowserType) Settings.browserType;

        switch (type) {

            case Chrome:
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("download.default_directory", "C://");

                DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setJavascriptEnabled(true);
                chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

                webDriver = new ChromeDriver(chromeOptions);
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                webDriver.get(Settings.testUrl);
                break;

            case IE:

                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                break;

            case Safari:
                WebDriverManager.safaridriver().setup();
                webDriver = new SafariDriver();
                break;

            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();

                break;
        }
        LOGGER.info("Tarayici acildi.");


        timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        date = new Date();
        System.out.println(new Timestamp(date.getTime()));  // 2021-03-24 16:34:26.666
        // number of milliseconds since January 1, 1970, 00:00:00 GMT
        //System.out.println(timestamp.getTime());


    }

    @AfterEach
    public void tearDown() {

        webDriver.quit();

    }

}
