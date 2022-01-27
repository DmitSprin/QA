package Tests;

import BaseTest.TestRunner;
import Components.Buttons.BuyButton;
import Components.Frameworks.ProductFrame;
import Components.Frameworks.ProductsFrame;
import Components.Utils.Component;
import Steps.ProductSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWithUsingComponent extends TestRunner {
    @Test(dataProvider = "products name")
    public void searchWithCatalogUsingComponent(String cat, String subCat, String prod) {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        var frame = Component.getComponent(ProductsFrame.class, "catalog");
        var product = Component.getComponent(ProductFrame.class, "iPhone 12", frame);
        Component.getComponent(BuyButton.class, "buttonBuy",product).click();
        String productName = productPage.orderConfirmText();
        Assert.assertTrue(productName.contains(prod));
    }
}