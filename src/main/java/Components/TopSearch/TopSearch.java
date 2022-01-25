package Components.TopSearch;

import Components.Utils.BaseComponent;
import Components.Utils.Component;
import Utils.ExplicitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TopSearch extends BaseComponent {

    private String nameIdentifier = Component.getIdentifier();

    private WebElement topSearch;

    @Override
    public WebElement build() {
        return ExplicitStrategy.waitForElement(
                construct());
    }

    @Override
    public By construct() {
        return By.xpath(".//input[@type='" + nameIdentifier + "']");
    }


    public Component sendMessageInTopFieldAndSearch(String text) {
        build().sendKeys(text);
        build().sendKeys(Keys.ENTER);
        return new Component();
    }
}