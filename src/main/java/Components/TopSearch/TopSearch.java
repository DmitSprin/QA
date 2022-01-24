package Components.TopSearch;

import Browser.BrowserСhoice;
import Components.Component;
import Components.IComponent;
import Utils.ExplicitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class TopSearch extends RemoteWebElement implements IComponent {

    private String nameIdentifier = Component.getIdentifier();

    private WebElement topSearch;

    @Override
    public WebElement construct() {
        return topSearch = ExplicitStrategy.waitForElement(BrowserСhoice
                .getDriver().findElement(By.xpath(".//button[contains(@class,'" + nameIdentifier + "')]")));
    }

    @Override
    public WebElement build() {
        return construct();
    }

}
