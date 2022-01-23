package BaseTest;

import Browser.BrowserFactory;
import Browser.BrowserСhoice;
import Steps.MainSteps;
import UserDao.UserRepo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TestRunner {
    //https://www.ctrs.com.ua/
    final static String baseUrl = "https://www.citrus.com.ua/uk/";

    public static MainSteps mainPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        BrowserСhoice.setDriver(BrowserFactory.CHROME_DRIVER);
        BrowserСhoice.getUrl(baseUrl);
        mainPage = MainSteps.getMainPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
      //  BrowserСhoice.closeBrowser();
    }

    @DataProvider(name = "exist user")
    public Object[][] getExistUser() {
        return new Object[][]{{UserRepo.getExistUser()}};
    }

    @DataProvider(name = "products name")
    public Object[][] productsName() {
        return new Object[][]{{"Смартфони", "Apple", "iPhone"}};
    }

    @DataProvider(name = "new user")
    public Object[][] getNewUser() {
        return new Object[][]{{UserRepo.createNewUser()}};
    }

    @DataProvider(name = "products", parallel = true)
    public Object[][] products() {
        return new Object[][]{{"iPhone"}, {"iPhone"}};
    }
}