package Pages;

import Browser.BrowserСhoice;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    BasePage() {
        PageFactory.initElements(BrowserСhoice.getDriver(), this);
    }

    public Dimension getWindowResolution() {
        return BrowserСhoice.getDriver().manage().window().getSize();
    }

    public String getCurrentUrl() {
        return BrowserСhoice.getDriver().getCurrentUrl();
    }

    public void setMaxWindowResolution() {
        BrowserСhoice.getDriver().manage().window().maximize();
    }
}