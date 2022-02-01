package Steps;

import Pages.LoginPage;
import UserDao.User;

public class LoginSteps extends LoginPage {

    private LoginPage loginPage = new LoginPage();

    // Business logics
    public LoginSteps loginByPhoneNumber(User dao) {
        loginPage.sendDataInNumberField(dao);
        loginPage.clickOnLoginButton();
        loginPage.sendInFieldForMessageVerification(dao);
        return new LoginSteps();
    }

    public LoginSteps loginByEmailNumber(User dao) {
        loginPage.clickOnLoginByEmail();
        loginPage.sendTextIntoEmailRegisterForm(dao);
        loginPage.clickOnLoginButton();
        loginPage.sendPasswordInPasswordField(dao);
        loginPage.clickOnLoginButton();
        return new LoginSteps();
    }

    public RegisterSteps goToRegisterPage() {
        loginPage.getRegisteringButton().click();
        return new RegisterSteps();
    }
}