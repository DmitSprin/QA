package Tests;

import BaseTest.TestRunner;
import Steps.LoginSteps;
import Steps.RegisterSteps;
import UserDao.User;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestRunner {

    @Test(dataProvider = "new user")
    @Description("this test checks the ability to register a new user")
    @Severity(SeverityLevel.NORMAL)
    public void createNewUser(User user) {
        LoginSteps loginPage = mainPage.goToLoginPage();
        RegisterSteps registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name = loginPage.getAccountNameText();
        Assert.assertEquals(name, user.getUserName());
    }

    //Negative test
    @Test(dataProvider = "exist user")
    @Description("this test checks the impossibility of registering a new user with an existing email")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewUserWithWrongCredential(User user) {
        LoginSteps loginPage = mainPage.goToLoginPage();
        RegisterSteps registerPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name = loginPage.getAccountNameText();
        Assert.assertNotEquals(name, user.getUserName());
    }
}