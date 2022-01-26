package Tests;

import BaseTest.TestRunner;
import Steps.ProductSteps;
import Utils.jsActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsabilityTest extends TestRunner {

    @Test()
    public void switchLanguage() {
        mainPage.changeLanguage();
        String URL = mainPage.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.ctrs.com.ua/uk/");
    }

    @Test()
    public void testScrollerPage() {
        var firstPosition = mainPage.getPoint();
        jsActions.scrollDown();
        mainPage.clickOnScrollButton();
        var secondPosition = mainPage.getPoint();
        Assert.assertNotEquals(firstPosition.getY(), secondPosition.getY());
    }

    @Test(dataProvider = "products name")
    public void scaleProductImageTest(String cat, String subCat, String pro) {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        var demBeforeScale = productPage.findAllProductsFromCatalogAndReturnWebElement().get(0).getSize().width;
        mainPage.setMaxWindowResolution();
        var demAfterScale = productPage.findAllProductsFromCatalogAndReturnWebElement().get(0).getSize().width;
        Assert.assertNotEquals(demAfterScale, demBeforeScale);
    }
}