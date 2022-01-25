package Tests;

import BaseTest.TestRunner;
import Components.Buttons.BuyButton;
import Components.TopSearch.TopSearch;
import Components.Utils.Component;
import Steps.LoginSteps;
import Steps.ProductSteps;
import Steps.RegisterSteps;
import UserDao.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends TestRunner {

    @Test(dataProvider = "products name")
    public void searchWithCatalog(String cat, String subCat, String prod) throws InterruptedException {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        productPage.clickOnFirstProduct();
        //productPage.clickOnBuyButton();
        Component.getComponent(BuyButton.class,"buyButton").click();
        String productName = productPage.orderConfirmText();
        Assert.assertTrue(productName.contains(prod));
    }

    @Test(dataProvider = "new user")
    public void addProductToWishList(User user) throws InterruptedException {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory("Смартфони", "Apple");
        productPage.clickOnFirstProduct();
        LoginSteps loginPage = mainPage.goToLoginPage();
        RegisterSteps registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        productPage.addToWishListButton();
        String numberOfProducts = mainPage.getNumberFomWishList();
        Assert.assertEquals(numberOfProducts, "1");
    }
}