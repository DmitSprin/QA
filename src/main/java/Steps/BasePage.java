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

    default <T> T waitUntilProductPageWillBeLoading() {
        WebElement product = BrowserСhoice.getDriver()
                .findElement(By.xpath("//div[contains(@class,'full-width df jcc aic slide')]"));
        Wait<WebDriver> wait = new WebDriverWait(BrowserСhoice.getDriver(), Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(product));
        return (T) this;

    }

    default <T> T waitUntilAllProductWillBeLoading() {
        List<WebElement> products = BrowserСhoice.getDriver()
                .findElements(By.xpath("//div[contains(@class,'md-description')] //h5"));
        Wait<WebDriver> wait = new WebDriverWait(BrowserСhoice.getDriver(), Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfAllElements(products));
        return (T) this;
    }
}