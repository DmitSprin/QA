package Tests;

import BaseTest.TestRunner;
import Steps.LoginSteps;
import Steps.RegisterSteps;
import UserDao.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestRunner {

    @Test(dataProvider = "new user")
    public void createNewUser(User user) {
        LoginSteps loginPage = mainPage.goToLoginPage();
        RegisterSteps registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name = loginPage.getAccountNameText();
        Assert.assertEquals(name, user.getUserName());
    }

    //Negative test
    @Test(dataProvider = "exist user")
    public void createNewUserWithWrongCredential(User user) {
        LoginSteps loginPage = mainPage.goToLoginPage();
        RegisterSteps registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name = loginPage.getAccountNameText();
        Assert.assertNotEquals(name, user.getUserName());
    }
}