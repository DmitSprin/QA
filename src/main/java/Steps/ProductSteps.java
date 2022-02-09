package Steps;

import Browser.BrowserСhoice;
import Pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;

public class ProductSteps extends ProductPage {

    private ProductPage productPage = new ProductPage();
    private Actions builder = new Actions(BrowserСhoice.getDriver());

    public void moveToSubMenu(String subProd) {
        List<WebElement> subCategories = productPage.getSubCategories();
        List<WebElement> subCategoriesSorted =
                subCategories.stream().filter(x -> x.getText().contains(subProd)).toList();
        subCategoriesSorted.stream().findFirst().get().click();
    }

    public void choiceСategory(String cat) {
        List<WebElement> allCategories = productPage.getCategories();
        allCategories.stream().filter(x -> x.getText().contains(cat))
                .forEach(x -> builder.moveToElement(x).build().perform());
    }

    public void choiceСategoryAndSubCategory(String cat, String sub) {
        List<WebElement> allCategories = productPage.getCategories();
        allCategories.stream().filter(x -> x.getText().contains(cat))
                .forEach(x -> builder.moveToElement(x).build().perform());
        moveToSubMenu(sub);
    }

    @When("User click on first product")
    public void weClickOnFirstProduct() {
        clickOnFirstProduct();
    }

    @When("User click on buy button")
    public void weClickOnBuyButton() {
        clickOnBuyButton();
    }

    @When("User choose {string} in catalog")
    public void weChooseCatalogInCatalog(String catalog) {
        choiceСategory(catalog);
    }

    @When("User choose {string} in sub catalog")
    public void weChooseSubCatalogInSubCatalog(String subCatalog) {
        moveToSubMenu(subCatalog);
    }

    @Then("User see {string} in basket")
    public void weSeeProductInBasket(String product) {
        String productName = orderConfirmText();
        Assert.assertTrue(productName.contains(product));
    }

    @When("User click on product with {string} name")
    public void weClickOnProductWithProductName(String prod) {
        System.out.println("productsFromSearch " + getProductsFromSearch());
        WebElement product = getProductsFromSearch()
                .stream().filter(x -> x.getText().contains(prod)).toList().get(0);
        product.click();
    }

    @When("User click on add to wish list button")
    public void weClickOnAddToWishListButton() {
        addToWishListButton();
    }
}