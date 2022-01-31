package Pages;

import Browser.BrowserСhoice;
import Utils.ExplicitStrategy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

@Getter
public class ProductPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class,'md-description')]//h5")
    private List<WebElement> productsFromSearch;

    @FindBy(xpath = "//div[@class='catalog-facet']//div[contains(@class,'-box pr productCardCategory')]")
    private List<WebElement> productsFromCatalog;

    @FindBy(xpath = ".//div[contains(@class,'border-box pr productCardCategory')]")
    private WebElement firstProductOnPage;

    @FindBy(xpath = ".//a[@class='df aic jcsb']//div")
    private List<WebElement> categories;

    @FindBy(xpath = ".//*[contains(@class ,'icon add-favorire icon')]")
    private WebElement addToWishList;

    @FindBy(xpath = ".//a[contains(@class,'submenu')]")
    private List<WebElement> subCategories;

    @FindBy(xpath = ".//div[contains(@class,'grid')]//div[contains(@class,'content')]")
    private WebElement orderConfirm;

    @FindBy(xpath = ".//div[@class='mt32']//button[contains(@class,'buyButton-')]")
    private WebElement buyButton;

    @FindBy(xpath = ".//div[contains(@class,'full-width df jcc aic slide')]")
    private WebElement productPageLoadMarker;

    public void clickOnFirstProduct() {
        firstProductOnPage.click();
        ExplicitStrategy.waitUntilElementToBeVisibility(productPageLoadMarker);
    }

    public void clickOnBuyButton() {
        WebElement waitingElement = ExplicitStrategy.waitForElement(buyButton);
        waitingElement.click();
    }

    public String orderConfirmText() {
        return orderConfirm.getText();
    }

    public List<String> findAllProductsFromSearchAndReturnName() {
        ExplicitStrategy.waitForElements(productsFromSearch);
        return productsFromSearch.stream().map(WebElement::getText).toList();
    }

    public List<WebElement> findAllProductsFromCatalogAndReturnWebElement() {
        return ExplicitStrategy.waitForElements(productsFromCatalog);
    }

    public void addToWishListButton() {
        LoginPage loginPageLocator = new LoginPage();
        PageFactory.initElements(BrowserСhoice.getDriver(), loginPageLocator);
        ExplicitStrategy.waitForElement(loginPageLocator.getAccount());
        addToWishList.click();
    }
}