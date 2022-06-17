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
        String elementKey = "signInButton";

        LOGGER.info("Page Title : " + webDriver.getTitle());

        DriverContext.waitElementClickable(webDriver.findElement(ReadFiles.readLocator(elementKey)));
        boolean isDisplayed = webDriver.findElement(ReadFiles.readLocator(elementKey)).isDisplayed();
        webDriver.findElement(ReadFiles.readLocator(elementKey)).sendKeys("Faruk AKYOL");

        Assertions.assertEquals(true, isDisplayed);


    }


}
