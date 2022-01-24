package Pages;

import UserDao.User;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage extends BasePage {

    @FindBy(xpath = ".//input[@name = 'name']")
    private WebElement registerFieldForName;

    @FindBy(xpath = ".//input[@name = 'phone']")
    private WebElement registerFieldForPhone;

    @FindBy(xpath = ".//input[@name = 'email']")
    private WebElement registerFieldForEmail;

    @FindBy(xpath = ".//input[@name = 'password']")
    private WebElement registerFieldForPassword;

    @FindBy(xpath = ".//div[@class='full-height df fdc jcc']//button[@type='submit']")
    private WebElement registerButton;

    public void sendNameInRegisterField(User user) {
        getRegisterFieldForName().sendKeys(user.getUserName());
    }

    public void sendEmailInRegisterField(User user) {
        getRegisterFieldForEmail().sendKeys(user.getEmail());
    }

    public void sendPasswordInRegisterField(User user) {
        getRegisterFieldForPassword().sendKeys(user.getPassword());
    }

    public void sendPhoneInRegisterField(User user) {
        getRegisterFieldForPhone().sendKeys(user.getPhoneNumber());
    }

    public void clickOnRegisterButton() {
        getRegisterButton().click();
    }
}