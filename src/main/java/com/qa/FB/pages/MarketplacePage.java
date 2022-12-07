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

public class MarketplacePage extends BaseClass {
	
	@FindBy(xpath = "//div[@role='banner']//div[4]/div[1]/span")
	WebElement acBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement lgoBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Create new listing')]")
	WebElement createBtn;

	public MarketplacePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clkTest() throws IOException {	
		createBtn.click();
		
		File srcF = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destF = new File("C:\\testing\\Screenshot\\listingPage.jpg");
		FileUtils.copyFile(srcF, destF);
		
		driver.navigate().back();
	}
	
	public void lgoTest() {
		
		acBtn.click();
		lgoBtn.click();
	}
	
	
	
}
