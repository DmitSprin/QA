package Components.Buttons;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import Utils.ExplicitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuyButton extends BaseComponent implements WebElement {

    private WebElement buyButton;

    private String nameIdentifier = Component.getIdentifier();
    //buyButton

    @Override
    public WebElement build() {
        return ExplicitStrategy.waitForElement(
                construct());
    }

    @Override
    public By construct() {
        return By.xpath(".//button[contains(@class,'" + nameIdentifier + "')]");
    }

    @Override
    public void click() {
        build().click();
    }

}