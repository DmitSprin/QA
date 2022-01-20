package Utils;

import Browser.BrowserСhoice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitStrategy {

    static WebDriverWait wait = new WebDriverWait(BrowserСhoice.getDriver(), Duration.ofSeconds(4));

    public static WebElement waitForElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static List<WebElement> waitForElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }

    public static WebElement waitUntilElementToBeVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitUntilAttributeContains(WebElement element, String arg, String value) {
        wait.until(ExpectedConditions.attributeContains(element, arg, value));
        return element;
    }
}