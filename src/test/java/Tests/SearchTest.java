package Tests;

import BaseTest.TestRunner;
import Steps.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SearchTest extends TestRunner {

    @Test(dataProvider = "products")
    public void searchWithText(String prod) throws InterruptedException {
        //MainPage mainPage = loadApplication();
        ProductPage productPage = mainPage.searchProductInTopSearch(prod);
        Thread.sleep(1000);
        List<String> products = productPage.findAllProductsAndReturnName();
        List<String> sortedProduct = products.stream().filter(x -> x.contains(prod)).toList();
        assert (sortedProduct.size() != 0);
        Assert.assertEquals(sortedProduct.size(), products.size());
    }

    @Test(dataProvider = "products name")
    public void searchWithCatalog(String cat, String subCat, String prod) {
        //MainPage mainPage = loadApplication();
        ProductPage productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        String productName = productPage.getNameFromFirstProduct();
        Assert.assertTrue(productName.contains(prod));
    }
}