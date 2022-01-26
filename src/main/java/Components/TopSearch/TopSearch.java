package Components.TopSearch;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TopSearch extends BaseComponent {

    @Override
    public By construct() {
        return By.xpath(".//input[@type='" + Component.getIdentifier() + "']");
    }

    public Component sendMessageInTopFieldAndSearch(String text) {
        build().sendKeys(text);
        build().sendKeys(Keys.ENTER);
        return new Component();
    }
}