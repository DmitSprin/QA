package Tests;

import BaseTest.TestRunner;
import Steps.MainPage;
import Steps.ProductPage;
import Utils.JsCod;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class UsabilityTest extends TestRunner {


    @Test()
    public void switchLanguage() {
        MainPage mainPage = loadApplication();
        mainPage.changeLanguage();
        String URL = mainPage.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.citrus.ua/");
    }

    @Test()
    public void testScrollerPage() {
        MainPage mainPage = loadApplication();
        var firstPosition = mainPage.getPoint();
        JsCod.scrollDown();
        mainPage.clickOnScrollButton();
        var secondPosition = mainPage.getPoint();
        Assert.assertNotEquals(firstPosition.getY(), secondPosition.getY());
    }

    @DataProvider(name = "products name")
    public Object[][] productsName() {
        return new Object[][]{{"Смартфоны", "Apple", "iPhone"}};
    }


    @Test(dataProvider = "products name")
    public void scaleProductImageTest(String cat, String subCat, String pro) {
        MainPage basePage = loadApplication();
        ProductPage productPage = basePage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        var demBeforeScale = productPage.returnFirstProduct().getSize().width;
        basePage.setMaxWindowResolution();
        var demAfterScale = productPage.returnFirstProduct().getSize().width;
        Assert.assertNotEquals(demAfterScale, demBeforeScale);
    }
}