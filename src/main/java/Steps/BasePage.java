package Steps;

import Browser.BrowserСhoice;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public interface BasePage {

    default Dimension getWindowResolution() {
        return BrowserСhoice.getDriver().manage().window().getSize();
    }

    default String getCurrentUrl() {
        return BrowserСhoice.getDriver().getCurrentUrl();
    }

    default void setMaxWindowResolution() {
        BrowserСhoice.getDriver().manage().window().maximize();
    }
}