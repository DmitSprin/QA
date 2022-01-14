package BaseTest;

import Browser.BrowserFactory;
import Browser.BrowserСhoice;
import Steps.MainPage;
import UserDao.UserRepo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TestRunner {
    final static String baseUrl = "https://www.citrus.com.ua/uk/";

    public static MainPage mainPage;

    public  void loadApplication() {
        BrowserСhoice.setDriver(BrowserFactory.CHROME_DRIVER);
        BrowserСhoice.getUrl(baseUrl);
        mainPage = MainPage.getMainPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BrowserСhoice.closeBrowser();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
       loadApplication();
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

    @DataProvider(name = "products"/*, parallel = true*/)
    public Object[][] products() {
        return new Object[][]{{"iPhone"}, {"iPhone"}};
    }
}