package Steps;

import Pages.RegisterPage;
import UserDao.User;
import UserDao.UserRepo;
import io.cucumber.java.en.When;

public class RegisterSteps extends RegisterPage {

    User user = UserRepo.createNewUser();

    //Business logics
    public RegisterSteps registerNewUser(User dao) {
        sendEmailInRegisterField(dao);
        sendNameInRegisterField(dao);
        sendPasswordInRegisterField(dao);
        sendPhoneInRegisterField(dao);
        clickOnRegisterButton();
        return new RegisterSteps();
    }

    @When("We send name in name field")
    public void weSendNameInNameField() {
        sendNameInRegisterField(user);
    }

    @When("We send phone number in number field")
    public void weSendPhoneNumberInNumberField() {
        sendPhoneInRegisterField(user);
    }

    @When("We send email in email field")
    public void weSendEmailInEmailField() {
        sendEmailInRegisterField(user);
    }

    @When("We send password in password field")
    public void weSendPasswordInPasswordField() {
        sendPasswordInRegisterField(user);
    }

    @When("We send register new user button")
    public void weSendRegisterNewUserButton() {
        clickOnRegisterButton();
    }
}