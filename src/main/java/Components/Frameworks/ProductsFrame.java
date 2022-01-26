package Components.Frameworks;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import org.openqa.selenium.By;


public class ProductsFrame extends BaseComponent {

    //catalog
    @Override
    public By construct() {
        return By.xpath("//div[@class= '" + Component.getIdentifier() + "-facet']");
    }
}