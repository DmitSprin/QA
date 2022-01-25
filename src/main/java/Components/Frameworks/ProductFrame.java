package Components.Frameworks;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import org.openqa.selenium.By;

public class ProductFrame extends BaseComponent {

//Apple iPhone 12 Pro 256GB Graphite (MGMP3)
private String nameIdentifier = Component.getIdentifier();

    @Override
    public By construct() {
        return By.xpath(".//a[contains(text(),'"+nameIdentifier+"')]");
    }
}
