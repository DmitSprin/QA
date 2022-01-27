package Steps;

import Browser.BrowserСhoice;
import Hooks.Hooks;
import Pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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



    @When("We click on first product")
    public void weClickOnFirstProduct() {
        productPage.clickOnFirstProduct();
    }

    @When("We click on buy button")
    public void weClickOnBuyButton() {
        productPage.clickOnBuyButton();
    }

    @When("We choose {string} in catalog")
    public void weChooseCatalogInCatalog(String catalog) {
        choiceСategory(catalog);
    }

    @When("We choose {string} in sub catalog")
    public void weChooseSubCatalogInSubCatalog(String subCatalog) {
        moveToSubMenu(subCatalog);
    }

    @Then("We see {string} in basket")
    public void weSeeProductInBasket(String product) {
        System.out.println(product);

    }
}