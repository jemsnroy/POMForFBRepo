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

public class HomePage extends BaseClass {

	@FindBy(partialLinkText = "Jemish Roy")
	WebElement usrName;
	
	@FindBy(xpath = "//span[contains(text(),'Marketplace')]")
	WebElement mktBtn;
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String usrNameTest() {
		return usrName.getText();
	}
	
	public void ssTest() throws IOException {
		
		File srcF = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destF = new File("C:\\testing\\Screenshot\\homePage.jpg");
		FileUtils.copyFile(srcF, destF);
	}
	
	public MarketplacePage mktTest() {
		mktBtn.click();
		return new MarketplacePage();
	}
	
	
}
