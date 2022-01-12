package Locators;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@Getter
public class ProductPageLocators {

    @FindBy(xpath = "//div[contains(@class,'md-description')] //h5")
    private List<WebElement> products;

    @FindBy(xpath = "//div[contains(@class,'border-box pr productCardCategory')]")
    private WebElement firstProductOnPage;

    @FindBy(xpath = "//a[@class='df aic jcsb'] //div")
    private List<WebElement> categories;

    @FindBy(xpath = "//*[contains(@class ,'icon add-favorire icon')]")
    private WebElement addToWishList;

    @FindBy(xpath = "//a[contains(@class,'submenu')]")
    private List<WebElement> subCategories;

    @FindBy(xpath = "//div[contains(@class,'grid')] //div[contains(@class,'content')]")
    private WebElement orderConfirm;

    @FindBy(xpath = "//div[@class='mt32'] //button[contains(@class, 'buyButton-')]")
    private WebElement buyButton;
}