package com.qa.FB.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.FB.utils.UtilClass;
import com.qa.FB.utils.WebEventListener;

public class BaseClass {
	
	public static WebDriver driver;
	//public static Logger log;
	
	public static Properties prop;
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	public BaseClass() {

		
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\POMForFB\\src\\main\\java\\com\\qa\\FB\\config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		
		String browserName = prop.getProperty("Browser");
		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumCopy\\SeleniumJars_Copy\\geckodriver.exe");
			driver = new FirefoxDriver();
			//log.debug("launching Firefox browser");
		} else if (browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCopy\\SeleniumJars_Copy\\chromedriver.exe");
			driver = new ChromeDriver();
			//log.debug("launching Chrome browser");
		} else {
			
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
			//log.debug("launching Safari browser");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		//log.debug("entering application URL");
	}
		
	}
	
	
	

