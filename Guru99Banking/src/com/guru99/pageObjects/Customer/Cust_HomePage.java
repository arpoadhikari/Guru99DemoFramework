package com.guru99.pageObjects.Customer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guru99.pageObjects.BasePage;
import com.guru99.utils.Constants;
import com.guru99.utils.Log;
import com.guru99.utils.ReadPropertiesFile;

public class Cust_HomePage extends BasePage{

	public Cust_HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Building WebElement for Logout link
	public static WebElement logOut_link() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "cust_home_logOut_link_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[Cust_HomePage.java] Logout link is found on the Customers Home Page");
			} catch (Exception e) {
				Log.error("[Cust_HomePage.java] Logout link is not found on the Customers Home Page");
				e.printStackTrace();
			}
		return element;
	}
	
	// Building WebElement for Logout link
	public static Alert logOut_alert() {
		try {
			alert = driver.switchTo().alert();
			Log.info("[Cust_HomePage.java] Logout alert is found");
			} catch (Exception e) {
				Log.error("[Cust_HomePage.java] Logout alert is found");
				e.printStackTrace();	
			}
		return alert;
	}
	
}
