package com.ali.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FB.base.BaseClass;
import com.qa.FB.pages.HomePage;
import com.qa.FB.pages.LoginPage;
import com.qa.FB.pages.MarketplacePage;

public class MarketplaceTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	MarketplacePage mp;

	public MarketplaceTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		hp = lp.lgnTest(prop.getProperty("Email"), prop.getProperty("Password"));
		mp = hp.mktTest();
	}

	@Test(priority = 1)
	public void vldCLKTest() throws IOException {
		mp.clkTest();
	}

	@Test(priority = 2)
	public void vldLgoTest() {
		mp.lgoTest();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
