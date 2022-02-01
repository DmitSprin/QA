package Components.Frames;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import org.openqa.selenium.By;

public class ProductsFrame extends BaseComponent {

    @Override
    public By construct() {
        return By.xpath("//div[@class= '" + Component.getIdentifier() + "-facet']");
    }
}