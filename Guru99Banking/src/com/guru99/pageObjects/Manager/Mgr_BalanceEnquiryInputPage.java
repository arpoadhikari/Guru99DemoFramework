package com.guru99.pageObjects.Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guru99.pageObjects.BasePage;
import com.guru99.utils.Constants;
import com.guru99.utils.Log;
import com.guru99.utils.ReadPropertiesFile;

public class Mgr_BalanceEnquiryInputPage extends BasePage{

	static WebElement element = null;
	static String element_location = null;
	
	public Mgr_BalanceEnquiryInputPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement accno_input(WebDriver driver) {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_be_accno_input_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("Account No. input box is found on Balance Enquiry page(Manager)");
		} catch (Exception e) {
			Log.error("Account No. input box is not found on Balance Enquiry page(Manager)");
			e.printStackTrace();
		}
		return element;
	}
	
	public static WebElement submit_button(WebDriver driver) {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_be_submit_button_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("Submit button is found on Balance Enquiry page(Manager)");
		} catch (Exception e) {
			Log.error("Submit button is not found on Balance Enquiry page(Manager)");
			e.printStackTrace();
		}
		return element;
	}

}
