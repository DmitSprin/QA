package Locators;

import lombok.Getter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPageLocator {

    @FindBy(xpath = "//input[@name = 'name']")
    private WebElement registerFieldForName;

    @FindBy(xpath = "//input[@name = 'phone']")
    private WebElement registerFieldForPhone;

    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement registerFieldForEmail;

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement  registerFieldForPassword;

    @FindBy(xpath = "//div[@class='full-height df fdc jcc'] //button[@type='submit']")
    private WebElement registerButton;
}