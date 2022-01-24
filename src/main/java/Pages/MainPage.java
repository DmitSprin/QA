package Pages;

import Browser.BrowserСhoice;
import Steps.MainSteps;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


@Getter
public class MainPage extends BasePage {

    @FindBy(xpath = ".//span[@class='ml8 dashed-text']")
    private WebElement loginButton;

    @FindBy(xpath = ".//a[contains(@class ,'dn aic jcc favorites')]//div[contains(@class,'df aic jcc pa badge')]")
    private WebElement wishList;

    @FindBy(xpath = ".//div[@class='menu--desktop__title']")
    private WebElement catalog;

    @FindBy(xpath = ".//div[contains(@class,'dib df basket')]")
    private WebElement basket;

    @FindBy(xpath = ".//div[contains(@class,'scrollButton')]")
    private WebElement scrollButton;

    @FindBy(xpath = ".//a[@href='/uk/']")
    private WebElement Language;

    @FindBy(xpath = ".//input[@type='text'] ")
    private WebElement topSearch;

    @FindBy(xpath = ".//a[contains(@class,'dn aic jcc favorites')]//div[@class='pr']")
    private WebElement wishCount;

    Actions builder = new Actions(BrowserСhoice.getDriver());

    public static MainSteps getMainPage() {
        return new MainSteps();
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public void clickOnWishList() {
        getWishList().click();
    }

    public void moveMouseToCatalogBar() {
        builder.moveToElement(getCatalog());
    }

    public Point getPoint() {
        WebElement el = getBasket();
        return el.getLocation();
    }

    public void changeLanguage() {
        getLanguage().click();
    }

    public void sendProductNameInTopSearch(String st) {
        getTopSearch().sendKeys(st);
        getTopSearch().sendKeys(Keys.ENTER);
    }

    public String getNumberFomWishList() {
        return getWishList().getText();
    }

    public void clickOnScrollButton() {
        getScrollButton().click();
    }
}