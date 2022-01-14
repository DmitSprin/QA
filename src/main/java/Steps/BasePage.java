package Steps;

import Browser.BrowserСhoice;
import org.openqa.selenium.Dimension;

public interface BasePage {

    default Dimension getWindowResolution() {
        return BrowserСhoice.getDriver().manage().window().getSize();
    }

    default String getCurrentUrl() {
        return BrowserСhoice.getDriver().getCurrentUrl();
    }

    default void setMaxWindowResolution() {
        BrowserСhoice.getDriver().manage().window().maximize();
    }
}