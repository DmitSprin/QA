package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class XpathLocators {
    //using child
    @FindBy(xpath = ".//button//div[@class='pr']//child::svg")
    private WebElement logIn;

    //using text() and boolean 'or'
    @FindBy(xpath = ".//a[@class='df aic jcsb']//div[text()='Смартфони' or text()='Смартфоны']")
    private WebElement smartphoneFromCatalog;

    //using function 'starts-with'
    @FindBy(xpath = ".//span[starts-with(text(),'044')]")
    private WebElement contactNumber;

    //using function 'contains'
    @FindBy(xpath = ".//a[contains(@class,'dn aic jcc favorites')]")
    private WebElement wishesList;

    //using following-sibling
    @FindBy(xpath = ".//ul//following-sibling::li")
    private List<WebElement> headersList;

    //using boolean '>' operator
    @FindBy(xpath = ".//span[@class='medium price-0-2-157'and text()>'800']")
    private List<WebElement> productWithMoreThen800Price;
}