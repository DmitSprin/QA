package Steps;

import Browser.BrowserСhoice;
import Hooks.Hooks;
import Pages.LoginPage;
import UserDao.User;
import UserDao.UserRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.Objects;

public class LoginSteps extends LoginPage {

    private LoginPage loginPage = new LoginPage();

    User user = UserRepo.getExistUser();

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

    @Given("User on main page")
    public void weOnMainPage() {
        String currentUrl = BrowserСhoice.getDriver().getCurrentUrl();
        String baseUrl = "https://www.citrus.com.ua/uk/";
        assert (Objects.equals(currentUrl, baseUrl));
    }

    @When("User click on sign in button")
    public void weClickOnSignInButton() {
        Hooks.getMainPage().goToLoginPage();
    }

    @When("User enter phone number in phone field")
    public void weEnterPhoneNumberInPhoneField() {
        loginByPhoneNumber(user);
    }

    @When("User click on register button")
    public void weClickOnRegisterButton() {
        goToRegisterPage();
    }

    @When("User click on login button")
    public void weClickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("User see successful message")
    public void weSeeSuccessfulMessage() {
        String phone = loginPage.getTextFromMobileMessageEntrance();
        Assert.assertTrue(phone.contains(user.getPhoneNumber()));
    }

    @When("User click on sign in by email")
    public void weClickOnSignInByEmail() {
        loginPage.getLoginByEmail().click();
    }

    @Then("User can see user name")
    public void weCanSeeUserName() {
        String name = loginPage.getAccountNameText();
        Assert.assertTrue(name.length() > 0);
    }

    @When("User enter email in email field")
    public void weEnterEmailInEmailField() {
        loginPage.sendTextIntoEmailRegisterForm(user);
        loginPage.clickOnLoginButton();
    }

    @When("User enter password in password field")
    public void weEnterPasswordInPasswordField() {
        loginPage.sendPasswordInPasswordField(user);
    }
}