package Steps;

import Pages.RegisterPage;
import UserDao.User;

public class RegisterSteps extends RegisterPage {
    private RegisterPage registerPage = new RegisterPage();

    //Business logics
    public RegisterSteps registerNewUser(User dao) {
        registerPage.sendEmailInRegisterField(dao);
        registerPage.sendNameInRegisterField(dao);
        registerPage.sendPasswordInRegisterField(dao);
        registerPage.sendPhoneInRegisterField(dao);
        registerPage.clickOnRegisterButton();
        return new RegisterSteps();
    }
}