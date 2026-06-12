package com.orangehrm.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.orangehrm.base.Baseclass;
import com.orangehrm.utilities.ExtentManager;

public class Dummyclass extends Baseclass {
	@Test
	public void dummytest() {
		// ExtentManager.startTest("DummyTest1 test");--This has been implemented
		// TestListener

		String title = getDriver().getTitle();
		ExtentManager.logStep("Verifying the title");

		assert title.equals("OrangeHRM") : "Test failed-Title is not Matching";

		System.out.println("Test passed-Title is Matching");
		ExtentManager.logSkip("This case is skipped");
		throw new SkipException("Skipping the test as part of testing");

	}
}
