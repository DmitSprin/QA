package Hooks;

import Browser.BrowserFactory;
import Browser.BrowserСhoice;
import Steps.MainSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    final static String baseUrl = "https://www.citrus.com.ua/uk/";

    public static MainSteps mainPage;

    @Before
    public void setUp() {
        BrowserСhoice.setDriver(BrowserFactory.CHROME_DRIVER);
        BrowserСhoice.getUrl(baseUrl);
        mainPage = new MainSteps();
    }

    public static MainSteps getMainPage() {
        return mainPage;
    }

    @After
    public void tearDown() {
        BrowserСhoice.closeBrowser();
    }
}