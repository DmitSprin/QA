package Utils;

import Browser.BrowserСhoice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JsCod {

    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) BrowserСhoice.getDriver();
        js.executeScript("window.scrollBy(0,1500)");
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(BrowserСhoice.getDriver(), Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }
}