package Components.Frameworks;

import Components.Buttons.BuyButton;
import Components.Utils.BaseComponent;
import Components.Utils.Component;
import org.openqa.selenium.By;

public class ProductFrame extends BaseComponent {

//Apple iPhone 12 Pro 256GB Graphite (MGMP3)
    @Override
    public By construct() {
        return By.xpath(".//a[contains(text(),'"+Component.getIdentifier()+"')]/parent::*");
    }

    public Component selectAndClickBuyButton(){
      var buyButton =  Component.getComponent(BuyButton.class,"buyButton",build());
        buyButton.click();
        return new Component();
    }
}