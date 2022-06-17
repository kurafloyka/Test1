package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserInitializer extends Base {

    public static void browserInitializer(BrowserType type) {


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
                webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
                LOGGER.info("Browser is opened...");
                //webDriver.get(Settings.testUrl);
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
    }
}
