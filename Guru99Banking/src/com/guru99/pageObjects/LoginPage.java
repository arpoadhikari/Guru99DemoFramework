package com.guru99.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guru99.utils.Constants;
import com.guru99.utils.Log;
import com.guru99.utils.ReadPropertiesFile;

public class LoginPage extends BasePage{
	
	static WebElement element = null;
	static String element_location = null;
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	// Building WebElement for UserID input box  
	public static WebElement userID_input() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "userId_input_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[LoginPage.java] UserID input box is found on the Login Page");
		} catch (Exception e) {
			Log.error("[LoginPage.java] UserID input box is not found on the Login Page");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Password input box 
	public static WebElement password_input() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "password_input_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[LoginPage.java] Password input box is found on the Login Page");
		} catch (Exception e) {
			Log.error("[LoginPage.java] Password input box is not found on the Login Page");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Login button 
	public static WebElement login_button() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "login_button_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[LoginPage.java] Login button is found on the Login Page");
		} catch (Exception e) {
			Log.error("[LoginPage.java] Login button is not found on the Login Page");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Reset button 
	public static WebElement reset_button() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "reset_button_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[LoginPage.java] Reset button is found on the Login Page");
		} catch (Exception e) {
			Log.error("[LoginPage.java] Reset button is not found on the Login Page");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for UserId text message field
	public static WebElement userId_msgText() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "userId_msgText_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[LoginPage.java] UserId text message field is found on the Login Page");
		} catch (Exception e) {
			Log.error("[LoginPage.java] UserId text message field is not found on the Login Page");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Password text message field
	public static WebElement password_msgText() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "password_msgText_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[LoginPage.java] Password text message field is found on the Login Page");
		} catch (Exception e) {
			Log.error("[LoginPage.java] Password text message field is not found on the Login Page");
			e.printStackTrace();
		}
		return element;
	}
	
}
