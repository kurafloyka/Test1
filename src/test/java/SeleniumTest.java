import base.DriverContext;
import element.ReadFiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static base.DriverContext.WaitForPageToLoad;


@Execution(ExecutionMode.CONCURRENT)
public class SeleniumTest extends BaseTest {


    @Test
    void goToInsiderMainPage() {


        LOGGER.info("Page Title : " + webDriver.getTitle());
        DriverContext.waitElementClickable(webDriver.findElement(ReadFiles.readLocator("InsiderLogo")));
        boolean isDisplayed = webDriver.findElement(ReadFiles.readLocator("InsiderLogo")).isDisplayed();
        Assertions.assertEquals(true, isDisplayed);

        webDriver.findElement(ReadFiles.readLocator("moreMenu")).click();

        webDriver.findElement(ReadFiles.readLocator("careersMenu")).click();




    }


}
