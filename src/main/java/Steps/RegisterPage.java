package Steps;

import Browser.BrowserСhoice;
import Locators.RegisterPageLocators;
import UserDao.User;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class RegisterPage implements BasePage {
    private RegisterPageLocators registerPageLocator = new RegisterPageLocators();

    public RegisterPage() {
        PageFactory.initElements(BrowserСhoice.getDriver(), registerPageLocator);
        BrowserСhoice.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    public void sendNameInRegisterField(User user) {
        registerPageLocator.getRegisterFieldForName().sendKeys(user.getUserName());
    }

    public void sendEmailInRegisterField(User user) {
        registerPageLocator.getRegisterFieldForEmail().sendKeys(user.getEmail());
    }

    public void sendPasswordInRegisterField(User user) {
        registerPageLocator.getRegisterFieldForPassword().sendKeys(user.getPassword());
    }

    public void sendPhoneInRegisterField(User user) {
        registerPageLocator.getRegisterFieldForPhone().sendKeys(user.getPhoneNumber());
    }

    public void clickOnRegisterButton() {
        registerPageLocator.getRegisterButton().click();
    }

    //Business logics
    public RegisterPage registerNewUser(User dao) {
        sendEmailInRegisterField(dao);
        sendNameInRegisterField(dao);
        sendPasswordInRegisterField(dao);
        sendPhoneInRegisterField(dao);
        clickOnRegisterButton();
        return new RegisterPage();
    }
}