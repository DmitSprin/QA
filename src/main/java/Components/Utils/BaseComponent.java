package Components.Utils;


import Utils.ExplicitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseComponent extends RemoteWebElement {

    private String identifier = Component.getIdentifier();

    private static WebElement parent = Component.getParent();

    public By construct() {
        return By.xpath(identifier);
    }

    public WebElement build() {
        if (parent != null) {
            WebElement Parent = ExplicitStrategy.waitForElement(parent);
            ExplicitStrategy.waitForElement(Parent.findElement(construct()));

        }
        return ExplicitStrategy.waitForElement(
                construct());
    }
}