package com.orangehrm.test;

import org.testng.annotations.Test;

import com.orangehrm.base.Baseclass;
import com.orangehrm.utilities.ExtentManager;

public class Dummyclass2 extends Baseclass {
	@Test
	public void dummyTest2() {
		//ExtentManager.startTest("DummyTest2 test");--This has been implemented TestListener
		String title = getDriver().getTitle();
		ExtentManager.logStep("Verifying the title");
		assert title.equals("OrangeHRM") : "Test failed-Title is not Matching";
		
		System.out.println("Test passed-Title is Matching");
		ExtentManager.logStep("Validation successfull");

	}
}
