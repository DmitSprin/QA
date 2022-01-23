package Pages;

import Browser.BrowserСhoice;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BasePage {

    BasePage() {
        PageFactory.initElements(BrowserСhoice.getDriver(), this);
        BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
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