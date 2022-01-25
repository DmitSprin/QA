package Components.Frameworks;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import org.openqa.selenium.By;


public class ProductsFrame  extends BaseComponent {

    private String nameIdentifier = Component.getIdentifier();
    //catalog

    @Override
    public By construct() {
        return By.xpath("//div[@class= '"+nameIdentifier+"-facet']");
    }
}