package Pages;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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
    private WebElement language;

    @FindBy(xpath = ".//input[@type='text'] ")
    private WebElement topSearch;

    @FindBy(xpath = ".//a[contains(@class,'dn aic jcc favorites')]//div[@class='pr']")
    private WebElement wishCount;

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnWishList() {
        wishList.click();
    }

    public void moveMouseToCatalogBar() {
        actions.moveToElement(catalog);
    }

    public Point getPoint() {
        WebElement basket = getBasket();
        return basket.getLocation();
    }

    public void changeLanguage() {
        language.click();
    }

    public void sendProductNameInTopSearch(String st) {
        topSearch.sendKeys(st);
        topSearch.sendKeys(Keys.ENTER);
    }

    public String getNumberFomWishList() {
        return wishList.getText();
    }

    public void clickOnScrollButton() {
        scrollButton.click();
    }
}