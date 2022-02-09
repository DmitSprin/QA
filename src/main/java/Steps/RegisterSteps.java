package Steps;

import Pages.RegisterPage;
import UserDao.User;
import UserDao.UserRepo;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class RegisterSteps extends RegisterPage {

    User user = UserRepo.createNewUser();

    //Business logics
    @Step("User register new account with name : {dao.userName} ,email" +
            " :{dao.email}, password : {dao.password}")
    public RegisterSteps registerNewUser(User dao) {
        sendEmailInRegisterField(dao);
        sendNameInRegisterField(dao);
        sendPasswordInRegisterField(dao);
        sendPhoneInRegisterField(dao);
        clickOnRegisterButton();
        return new RegisterSteps();
    }

    @When("User send name in name field")
    public void weSendNameInNameField() {
        sendNameInRegisterField(user);
    }

    @When("User send phone number in number field")
    public void weSendPhoneNumberInNumberField() {
        sendPhoneInRegisterField(user);
    }

    @When("User send email in email field")
    public void weSendEmailInEmailField() {
        sendEmailInRegisterField(user);
    }

    @When("User send password in password field")
    public void weSendPasswordInPasswordField() {
        sendPasswordInRegisterField(user);
    }

    @When("User send register new user button")
    public void weSendRegisterNewUserButton() {
        clickOnRegisterButton();
    }
}