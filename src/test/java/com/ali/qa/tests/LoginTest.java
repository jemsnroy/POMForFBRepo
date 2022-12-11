/*
 * @Author Jemish N. Roy
 * */

package com.ali.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.FB.base.BaseClass;
import com.qa.FB.pages.HomePage;
import com.qa.FB.pages.LoginPage;

public class LoginTest extends BaseClass {
	//Logger log = Logger.getLogger("devpinoyLogger");
	LoginPage lp;
	HomePage hp;

	public LoginTest() {

		super();
	}

	@BeforeMethod

	public void setUp() {
		//log.debug(
			//	"****************************** Starting test cases execution  *****************************************");

		initialization();
		lp = new LoginPage();
	}

	@Test(priority = 1)
	public void vldLinkTest() {
		//log.debug("****************************** starting test case *****************************************");
		//log.debug("****************************** vldLinkTest *****************************************");

		SoftAssert sf = new SoftAssert();
		String expLink = prop.getProperty("URL");
		String acLink = lp.linkTest();
		sf.assertEquals(expLink, acLink);

		sf.assertAll();

		//log.debug("****************************** ending test case *****************************************");
		//log.debug("****************************** vldLinkTest *****************************************");
	}

	@Test(priority = 2)
	public void vldTitleTest() {

		//log.debug("****************************** starting test case *****************************************");
		//log.debug("****************************** vldTitleTest *****************************************");

		String expTitle = prop.getProperty("Title");
		String acTitle = lp.titleTest();
		Assert.assertEquals(expTitle, acTitle);

		//log.debug("****************************** ending test case *****************************************");
		//log.debug("****************************** vldTitleTest *****************************************");
	}

	@Test(priority = 3)
	public void vldElementTest() {

		//log.debug("****************************** starting test case *****************************************");
		//log.debug("****************************** vldElementTest *****************************************");

		boolean flag = lp.elementTest();
		Assert.assertTrue(flag);

		//log.debug("****************************** ending test case *****************************************");
		//log.debug("****************************** vldElementTest *****************************************");

	}

	@Test(priority = 4)
	public void vldSSTest() throws IOException {

		//log.debug("****************************** starting test case *****************************************");
		//log.debug("****************************** vldSSTest *****************************************");

		lp.ssTest();

		//log.debug("****************************** ending test case *****************************************");
		//log.debug("****************************** vldSSTest *****************************************");

	}

	@Test(priority = 5)
	public void vldLgnTest() {

		//log.debug("****************************** starting test case *****************************************");
		//log.debug("****************************** vldLgnTest *****************************************");

		hp = lp.lgnTest(prop.getProperty("Email"), prop.getProperty("Password"));

		//log.debug("****************************** ending test case *****************************************");
		//log.debug("****************************** vldLgnTest *****************************************");

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

		//log.debug("****************************** Browser is closed *****************************************");
	}

}
