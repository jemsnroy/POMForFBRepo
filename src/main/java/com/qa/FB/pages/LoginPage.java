package com.qa.FB.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FB.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(name = "login")
	WebElement lgnBtn;

	@FindBy(id = "email")
	WebElement emField;

	@FindBy(id = "pass")
	WebElement psField;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public String linkTest() {

		return driver.getCurrentUrl();
	}
	
	public String titleTest() {
	return	driver.getTitle();
	}

	public boolean elementTest() {
		return lgnBtn.isDisplayed();
	}

	public void ssTest() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\testing\\Screenshot\\lgnPage.jpg");
		FileUtils.copyFile(srcFile, destFile);
	}

	public HomePage lgnTest(String email, String pass) {

		emField.sendKeys(email);
		psField.sendKeys(pass);
		lgnBtn.click();

		return new HomePage();

	}
	
	

}
