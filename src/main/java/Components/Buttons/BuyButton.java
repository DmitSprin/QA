package Components.Buttons;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuyButton extends BaseComponent implements WebElement {

    @Override
    public By construct() {
        return By.xpath(".//button[contains(@class,'" + Component.getIdentifier() + "')]");
    }
}