package BaseTest;


import Browser.BrowserFactory;
import Browser.BrowserСhoice;
import Steps.MainPage;
import org.testng.annotations.AfterTest;


public class TestRunner {
    // final static String baseUrl = "https://www.citrus.ua/";
    final static String baseUrl = "https://www.citrus.com.ua/uk/";

    public static MainPage loadApplication(){
        BrowserСhoice.setDriver(BrowserFactory.CHROME_DRIVER);
        BrowserСhoice.getUrl(baseUrl);

        return  new MainPage();
    }
    @AfterTest(alwaysRun = true )
    public void tearDown(){
        //   BrowserChoice.closeBrowser();

    }


}