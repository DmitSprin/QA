package Tests;

import BaseTest.TestRunner;
import Components.Buttons.BuyButton;
import Components.Utils.Component;
import Steps.LoginSteps;
import Steps.ProductSteps;
import Steps.RegisterSteps;
import UserDao.User;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends TestRunner {

    @Test(dataProvider = "products name")
    @Description("this test confirms the possibility of ordering a product")
    @Severity(SeverityLevel.BLOCKER)
    public void searchWithCatalog(String cat, String subCat, String prod) {
        ProductSteps productPage = mainPage.moveToCatalog();
        productPage.choiceСategoryAndSubCategory(cat, subCat);
        productPage.clickOnFirstProduct();
        Component.getComponent(BuyButton.class,"buyButton").click();
        String productName = productPage.orderConfirmText();
        Assert.assertTrue(productName.contains(prod));
    }

    @Test(dataProvider = "new user")
    @Description("this test checks the ability to add a product to wishlist")
    @Severity(SeverityLevel.NORMAL)
    public void addProductToWishList(User user) {
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