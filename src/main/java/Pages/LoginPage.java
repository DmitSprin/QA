package Pages;

import UserDao.User;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath = ".//input[@name='phone']")
    private WebElement entryFieldByLoginByPhone;

    @FindBy(xpath = ".//span[contains(@class,'dashed-text autorizeName')]")
    private WebElement account;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordFormForLogin;

    @FindBy(xpath = ".//div[@class='full-height df fdc jcc'] //p")
    private WebElement mobileMessageEntrance;

    @FindBy(xpath = ".//input[@name ='code']")
    private WebElement fieldForMessageVerification;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement loginByPhone;

    @FindBy(xpath = ".//div[@class='full-height df fdc jcc']//button[@type='button']")
    private WebElement loginByEmail;

    @FindBy(xpath = ".//input[@name='email']")
    private WebElement entryFieldByLoginByEmail;

    @FindBy(xpath = ".//div[@class='full-height df fdc jcc']//a[@class='link']")
    private WebElement registeringButton;

    public void clickOnLoginButton() {
        getLoginByPhone().click();
    }

    public void sendDataInNumberField(User user) {
        getEntryFieldByLoginByPhone().sendKeys(user.getPhoneNumber());
    }

    public String getTextFromMobileMessageEntrance() {
        return getMobileMessageEntrance().getText();
    }

    public void sendTextIntoEmailRegisterForm(User dao) {
        getEntryFieldByLoginByEmail().sendKeys(dao.getEmail());
    }

    public void clickOnLoginByEmail() {
        getLoginByEmail().click();
    }

    public void sendPasswordInPasswordField(User user) {
        getPasswordFormForLogin().sendKeys(user.getPassword());
    }

    public void sendInFieldForMessageVerification(User user) {
        getFieldForMessageVerification().sendKeys(user.getPhoneNumber());
    }

    public String getAccountNameText() {
        return getAccount().getText();
    }
}

