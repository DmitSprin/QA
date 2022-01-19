package Utils;

import Browser.BrowserСhoice;
import Locators.LoginPageLocator;
import Steps.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
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

    //this method wait until page with product will be loaded
    public static void waitUntilProductPageWillBeLoading() {
        LoginPageLocator loginPageLocator = new LoginPageLocator();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(".//div[contains(@class,'full-width df jcc aic slide')]")));
    }

    public WebElement waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement waitUntilAttributeContains(WebElement element, String arg, String value) {
        wait.until(ExpectedConditions.attributeContains(element, arg, value));
        return element;
    }
}