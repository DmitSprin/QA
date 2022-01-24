package Components.Buttons;

import Browser.BrowserСhoice;
import Components.Component;
import Components.IComponent;
import Utils.ExplicitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


public class BuyButton extends RemoteWebElement implements IComponent {

    private WebElement buyButton;

    private String nameIdentifier = Component.getIdentifier();
    //buyButton

    @Override
    public WebElement construct() {
        return buyButton = ExplicitStrategy.waitForElement(BrowserСhoice
                .getDriver().findElement(By.xpath(".//button[contains(@class,'" + nameIdentifier + "')]")));

    }

    @Override
    public WebElement build() {
        return construct();
    }

    public void click() {
        construct().click();
    }

}