package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.Baseclass;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.ExtentManager;

public class HomePageTest extends Baseclass {

private LoginPage loginPage;
private HomePage homePage;

@BeforeMethod
public void setUp() {
loginPage = new LoginPage(getDriver());
homePage = new HomePage(getActionDriver());
loginPage.login("admin", "admin123");
}

@Test
public void verifyOrangeHRMLogo() {
ExtentManager.logStep("Verifying OrangeHRM logo is visible on home page");
Assert.assertTrue(homePage.verifyOrangeHRMlogo(), "OrangeHRM logo is not visible");
ExtentManager.logStep("Validation successful");
}
}

