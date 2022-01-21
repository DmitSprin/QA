package Pages;

import Browser.BrowserСhoice;
import Utils.ExplicitStrategy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

@Getter
public class ProductPage  extends  BasePage{

    @FindBy(xpath = "//div[contains(@class,'md-description')]//h5")
    private List<WebElement> products;

    @FindBy(xpath = "//div[contains(@class,'border-box pr productCardCategory')]")
    private WebElement firstProductOnPage;

    @FindBy(xpath = "//a[@class='df aic jcsb']//div")
    private List<WebElement> categories;

    @FindBy(xpath = "//*[contains(@class ,'icon add-favorire icon')]")
    private WebElement addToWishList;

    @FindBy(xpath = "//a[contains(@class,'submenu')]")
    private List<WebElement> subCategories;

    @FindBy(xpath = "//div[contains(@class,'grid')]//div[contains(@class,'content')]")
    private WebElement orderConfirm;

    @FindBy(xpath = "//div[@class='mt32']//button[contains(@class,'buyButton-')]")
    private WebElement buyButton;

    @FindBy(xpath = "//div[contains(@class,'full-width df jcc aic slide')]")
    private WebElement productPageLoadMarker;

    public String getNameFromFirstProduct() {
        return getFirstProductOnPage().getText();
    }

    public void clickOnFirstProduct() {
        getFirstProductOnPage().click();
        ExplicitStrategy.waitUntilElementToBeVisibility(getProductPageLoadMarker());
    }

    public WebElement returnFirstProduct() {
        return getFirstProductOnPage();
    }

    public void clickOnBuyButton() {
        WebElement waitingElement = ExplicitStrategy.waitForElement(getBuyButton());
        waitingElement.click();
    }

    public String orderConfirmText() {
        return getOrderConfirm().getText();
    }

    public List<String> findAllProductsAndReturnName() {
        ExplicitStrategy.waitForElements(getProducts());
        return getProducts().stream().map(WebElement::getText).toList();
    }

    public void addToWishListButton() {
        LoginPage loginPageLocator = new LoginPage();
        PageFactory.initElements(BrowserСhoice.getDriver(), loginPageLocator);
        ExplicitStrategy.waitForElement(loginPageLocator.getAccount());
        getAddToWishList().click();
    }
}