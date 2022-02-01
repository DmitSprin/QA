package Components.Utils;

import Utils.ExplicitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class BaseComponent extends RemoteWebElement {

    public By construct() {
        return By.xpath(Component.getIdentifier());
    }

    public WebElement build() {
        if (Component.getParent() != null) {
            WebElement parentWebElement = ExplicitStrategy.waitForElement(Component.getParent());
            return ExplicitStrategy.waitForElement(parentWebElement.findElement(construct()));
        }
        return ExplicitStrategy.waitForElement(
                construct());
    }
}