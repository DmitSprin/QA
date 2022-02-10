package Tests;

import BaseTest.TestRunner;
import Components.Frames.ProductFrame;
import Components.Frames.ProductsFrame;
import Components.Utils.Component;
import Steps.ProductSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

public class SearchTest extends TestRunner {

    @Test(dataProvider = "products")
    @Description("this test check the ability to find an item using a simple search")
    @Severity(SeverityLevel.NORMAL)
    public void searchWithText(String prod) {
        ProductSteps productPage = mainPage.searchProductInTopSearch(prod);
        List<String> products = productPage.findAllProductsFromSearchAndReturnName();
        List<String> sortedProduct = products.stream().filter(x -> x.contains(prod))
                .collect(Collectors.toList());
        assert (sortedProduct.size() != 0);
        Assert.assertEquals(sortedProduct.size(), products.size());
    }

    @Test(dataProvider = "products name")
    @Description("this test check the ability to find an item using a catalog")
    @Severity(SeverityLevel.NORMAL)
    public void searchWithCatalog(String cat, String subCat, String prod) {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        String productName = productPage.getProductsFromCatalog().get(0).getText();
        Assert.assertTrue(productName.contains(prod));
    }

    @Test(dataProvider = "products name")
    public void searchWithCatalogComponent(String cat, String subCat, String prod) {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        var MainFrame = Component.getComponent(ProductsFrame.class, "catalog");
        Component.getComponent(ProductFrame.class, "Apple iPhone 11 ", MainFrame).click();
    }
}