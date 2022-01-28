package Steps;

import Hooks.Hooks;
import Pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class MainSteps extends MainPage {

    public LoginSteps goToLoginPage() {
        clickOnLoginButton();
        return new LoginSteps();
    }

    public ProductSteps searchProductInTopSearch(String product) {
        sendProductNameInTopSearch(product);
        return new ProductSteps();
    }

    public ProductSteps moveToCatalog() {
        moveMouseToCatalogBar();
        return new ProductSteps();
    }

    @When("We move mouse to the catalog")
    public void weMoveMouseToTheCatalog() {
        Hooks.getMainPage().moveToCatalog();
    }

    @When("We send {string} in top search field")
    public void weSendProductNameInTopSearchField(String product) {
        getTopSearch().sendKeys(product);
    }

    @When("We click on search button")
    public void weClickOnSearchButton() {
        getTopSearch().sendKeys(Keys.ENTER);
    }

    @Then("We should see product in basket")
    public void weShouldSeeProductInBasket() {
        String numberOfProducts = getNumberFomWishList();
        Assert.assertEquals(numberOfProducts, "1");
    }
}