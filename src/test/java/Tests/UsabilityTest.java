package Tests;

import BaseTest.TestRunner;
import Steps.ProductSteps;
import Utils.jsActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsabilityTest extends TestRunner {

    @Test()
    @Description("this test check the ability to change the language")
    @Severity(SeverityLevel.MINOR)
    public void switchLanguage() {
        mainPage.changeLanguage();
        String URL = mainPage.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.ctrs.com.ua/uk/");
    }

    @Test()
    @Description("this test check the ability to use interactive elements of the site")
    @Severity(SeverityLevel.TRIVIAL)
    public void testScrollerPage() {
        var firstPosition = mainPage.getPoint();
        jsActions.scrollDown();
        mainPage.clickOnScrollButton();
        var secondPosition = mainPage.getPoint();
        Assert.assertNotEquals(firstPosition.getY(), secondPosition.getY());
    }

    @Test(dataProvider = "products name")
    @Description("check for icon scaling depending on screen size change")
    @Severity(SeverityLevel.TRIVIAL)
    public void scaleProductImageTest(String cat, String subCat, String pro) {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        var demBeforeScale = productPage.findAllProductsFromCatalogAndReturnWebElement().get(0).getSize().width;
        mainPage.setMaxWindowResolution();
        var demAfterScale = productPage.findAllProductsFromCatalogAndReturnWebElement().get(0).getSize().width;
        Assert.assertNotEquals(demAfterScale, demBeforeScale);
    }
}