package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class DriverContext extends Base {

    //public static WebDriver webDriver;


    //static WebDriver driver;

    public static void WaitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;

        ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS Ready
        boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");

        if (!jsReady)
            wait.until(jsLoad);

    }

    public static void WaitForElementVisible(final WebElement elementFindBy) {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    public static void WaitForElementTextVisible(final WebElement elementFindBy, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    public static void WaitUntilTextDisplayed(final By element, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(textDisplayed(element, text));
    }

    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text) {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }

    public static void WaitElementEnabled(final By elementFindBy) {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }

    public static void waitElementClickable(final WebElement elementFindBy) {

        WebDriverWait wait = new WebDriverWait(webDriver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(elementFindBy));
    }

    public static void scrollToElement(final WebElement elementFindBy) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", elementFindBy);

    }

    public static void openWindowsByIndex(int index) {
        Set<String> windowHandles = webDriver.getWindowHandles();
        List<String> windowStrings = new ArrayList<>(windowHandles);
        String reqWindow = windowStrings.get(index);
        webDriver.switchTo().window(reqWindow);
        //LOGGER.info("Switched to " + webDriver.getTitle());


    }


}

