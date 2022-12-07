package com.qa.FB.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.FB.base.BaseClass;

public class RegisterPage extends BaseClass {

	@FindBy(xpath = "//a[@role='button' and @data-testid = 'open-registration-form-button']")
	WebElement cnaBtn;

	@FindBy(name = "firstname")
	WebElement fName;

	@FindBy(name = "lastname")
	WebElement lName;

	@FindBy(name = "reg_email__")
	WebElement email;

	@FindBy(id = "password_step_input")
	WebElement pass;

	@FindBy(id = "day")
	WebElement day;

	@FindBy(id = "month")
	WebElement month;
	
	@FindBy(id = "year")
	WebElement year;
	
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	WebElement gender;

	public RegisterPage() {

		PageFactory.initElements(driver, this);

	}

	public void cnaTest(String fN, String lN, String el, String psw) {

		cnaBtn.click();

		fName.sendKeys(fN);
		lName.sendKeys(lN);
		email.sendKeys(el);
		pass.sendKeys(psw);

		
		Select s1 = new Select(day);
		s1.selectByVisibleText(prop.getProperty("Day"));
		
		Select s2 = new Select(month);
		s2.selectByVisibleText(prop.getProperty("Month"));
		
		Select s3 = new Select(year);
		s3.selectByVisibleText(prop.getProperty("Year"));
		
		gender.click();
	}

}
