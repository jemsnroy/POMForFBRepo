package com.ali.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FB.base.BaseClass;
import com.qa.FB.pages.RegisterPage;
import com.qa.FB.utils.UtilClass;

public class RegisterTest extends BaseClass {

	String sheetName = "Sheet1";

	RegisterPage rp;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		rp = new RegisterPage();
	}

	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][] = UtilClass.getRegisterData(sheetName);
		return data;
	}
	

	@Test(dataProvider = "getRegisterData")
	public void vldCNATest(String fnA, String lnA, String elA, String psA) {
	rp.cnaTest(fnA, lnA, elA, psA);	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}