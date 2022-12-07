package com.ali.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FB.base.BaseClass;
import com.qa.FB.pages.HomePage;
import com.qa.FB.pages.LoginPage;
import com.qa.FB.pages.MarketplacePage;

public class HomeTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	MarketplacePage mp;

	public HomeTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		lp = new LoginPage();
		hp = lp.lgnTest(prop.getProperty("Email"), prop.getProperty("Password"));

	}

	@Test(priority = 1)
	public void vldUsrNameTest() {
		String expText = prop.getProperty("UserName");
		String acText = hp.usrNameTest();
		Assert.assertEquals(expText, acText);
	}

	@Test(priority = 2)
	public void vldSSTest() throws IOException {

		hp.ssTest();
	}

	@Test(priority = 3)
	public void vldMktTest() {
		mp = hp.mktTest();
	}

	@AfterMethod
	public void tearDown() {
	
		driver.quit();
	}

}
