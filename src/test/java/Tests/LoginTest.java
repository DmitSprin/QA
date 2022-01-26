package Tests;

import BaseTest.TestRunner;
import Steps.LoginSteps;
import UserDao.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestRunner {

    @Test(dataProvider = "exist user")
    public void loginByPhone(User user) {
        LoginSteps loginPage = mainPage.goToLoginPage().loginByPhoneNumber(user);
        String phone = loginPage.getTextFromMobileMessageEntrance();
        Assert.assertTrue(phone.contains(user.getPhoneNumber()));
    }

    @Test(dataProvider = "exist user")
    public void loginByEmail(User user) {
        LoginSteps loginPage = mainPage.goToLoginPage().loginByEmailNumber(user);
        String name = loginPage.getAccountNameText();
        Assert.assertEquals(name, user.getUserName());
    }
}