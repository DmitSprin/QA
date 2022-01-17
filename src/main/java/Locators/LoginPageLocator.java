package Locators;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPageLocator extends MainPageLocators {

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement entryFieldByLoginByPhone;

    @FindBy(xpath = "//span[contains(@class,'dashed-text autorizeName')]")
    private WebElement account;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordFormForLogin;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc'] //p")
    private WebElement mobileMessageEntrance;

    @FindBy(xpath = "//input[@name ='code']")
    private WebElement fieldForMessageVerification;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginByPhone;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc']//button[@type='button']")
    private WebElement loginByEmail;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement entryFieldByLoginByEmail;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc']//a[@class='link']")
    private WebElement registeringButton;
}