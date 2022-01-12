package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class XpathLocators {
    //using child
    @FindBy(xpath = "//button //div[@class='pr']//child::*")
    WebElement logIn;

    //using text() and boolean 'or'
    @FindBy(xpath = "//*[@class='df aic jcsb'] //*[text()='Смартфони' or text()='Смартфоны']")
    WebElement smartphoneFromCatalog;

    //using function 'starts-with'
    @FindBy(xpath = "//span[starts-with(text(),'044')]")
    WebElement contactNumber;

    //using function 'contains'
    @FindBy(xpath = "//a[contains(@class,'dn aic jcc favorites')]")
    WebElement wishList;

    //using following-sibling
    @FindBy(xpath = "//ul//following-sibling::li")
    List<WebElement> headerList;

    //using boolean '>' operator
    @FindBy(xpath = "//span[@class='medium price-0-2-157' and text()>'800']")
    List<WebElement> productWithMoreThen800Price;

}