package Pages;

import UserDao.User;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath = ".//input[@name='phone']")
    private WebElement loginByPhoneField;

    @FindBy(xpath = ".//span[contains(@class,'dashed-text autorizeName')]")
    private WebElement account;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[@class='full-height df fdc jcc'] //p")
    private WebElement mobileMessageEntrance;

    @FindBy(xpath = ".//input[@name ='code']")
    private WebElement messageVerificationField;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement loginByPhoneButton;

    @FindBy(xpath = ".//div[@class='full-height df fdc jcc']//button[@type='button']")
    private WebElement loginByEmail;

    @FindBy(xpath = ".//input[@name='email']")
    private WebElement emailLoginField;

    @FindBy(xpath = ".//div[@class='full-height df fdc jcc']//a[@class='link']")
    private WebElement registeringButton;

    public void clickOnLoginButton() {
        loginByPhoneButton.click();
    }

    public void sendDataInNumberField(User user) {
        loginByPhoneField.sendKeys(user.getPhoneNumber());
    }

    public String getTextFromMobileMessageEntrance() {
        return mobileMessageEntrance.getText();
    }

    public void sendTextIntoEmailRegisterForm(User dao) {
        emailLoginField.sendKeys(dao.getEmail());
    }

    public void clickOnLoginByEmail() {
        loginByEmail.click();
    }

    public void sendPasswordInPasswordField(User user) {
        passwordField.sendKeys(user.getPassword());
    }

    public void sendInFieldForMessageVerification(User user) {
        messageVerificationField.sendKeys(user.getPhoneNumber());}

    public String getAccountNameText() {
        return account.getText();
    }
}