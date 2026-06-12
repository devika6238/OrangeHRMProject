package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.Baseclass;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

import com.orangehrm.utilities.DataProviders;
import com.orangehrm.utilities.ExtentManager;

public class LoginPageTest extends Baseclass {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setupPages() {

        // REMOVE Thread.sleep (very important fix)
       
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getActionDriver());
    }

    @Test(dataProvider = "validLoginData", dataProviderClass = DataProviders.class)
    public void verifyValidLoginTest(String userName, String password) {

        System.out.println("Running valid login on thread: " + Thread.currentThread().getId());

        ExtentManager.logStep("Logging in with valid credentials");

        // ✅ USE DATA PROVIDER VALUES
        loginPage.login(userName, password);

        ExtentManager.logStep("Waiting for dashboard load");

        // OPTIONAL but strongly recommended:
        // add wait inside HomePage method OR here

        Assert.assertTrue(
                homePage.isAdminTabVisible(),
                "Admin tab should be visible after successful login"
        );

        ExtentManager.logStep("Login validation successful");

        homePage.logout();

        ExtentManager.logStep("Logged out successfully");
    }

    @Test(dataProvider = "inValidLoginData", dataProviderClass = DataProviders.class)
    public void invalidLoginTest(String userName, String password) {

        System.out.println("Running invalid login on thread: " + Thread.currentThread().getId());

        ExtentManager.logStep("Logging in with invalid credentials");

        loginPage.login(userName, password);

        String expectedErrorMessage = "Invalid credentials";

        Assert.assertTrue(
                loginPage.verifyErrorMessage(expectedErrorMessage),
                "Invalid error message not displayed"
        );

        ExtentManager.logStep("Invalid login validation successful");
    }
}