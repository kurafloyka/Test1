import base.DriverContext;
import element.ReadFiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


@Execution(ExecutionMode.CONCURRENT)
public class SeleniumTest extends BaseTest {


    @Test
    void goToFacebookLoginPage() {


        LOGGER.info("Page Title : " + webDriver.getTitle());
        sendKeys("signInButton", "Faruk AKYOL");


    }


    public void sendKeys(String elementKey, String data) {
        DriverContext.waitElementClickable(webDriver.findElement(ReadFiles.readLocator(elementKey)));
        boolean isDisplayed = webDriver.findElement(ReadFiles.readLocator(elementKey)).isDisplayed();
        Assertions.assertEquals(true, isDisplayed);
        webDriver.findElement(ReadFiles.readLocator(elementKey)).sendKeys(data);
        
    }


}
