package com.guru99.pageObjects.Manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.guru99.pageObjects.BasePage;
import com.guru99.utils.Constants;
import com.guru99.utils.Log;
import com.guru99.utils.ReadPropertiesFile;

public class Mgr_BalanceEnquiryInputPage extends BasePage{
	
	public Mgr_BalanceEnquiryInputPage(WebDriver driver) {
		super(driver);
	}
	
	// Building WebElement for Account No. input box
	public static WebElement accno_input() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_beip_accno_input_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[Mgr_BalanceEnquiryInputPage.java] Account No. input box is found on Balance Enquiry page(Manager)");
		} catch (Exception e) {
			Log.error("[Mgr_BalanceEnquiryInputPage.java] Account No. input box is not found on Balance Enquiry page(Manager)");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Submit Button
	public static WebElement submit_button() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_be_submit_button_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[Mgr_BalanceEnquiryInputPage.java] Submit button is found on Balance Enquiry Input page(Manager)");
		} catch (Exception e) {
			Log.error("[Mgr_BalanceEnquiryInputPage.java] Submit button is not found on Balance Enquiry Input page(Manager)");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Reset Button
	public static WebElement reset_button() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_beip_reset_button_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[Mgr_BalanceEnquiryInputPage.java] Reset button is found on Balance Enquiry Input page(Manager)");
		} catch (Exception e) {
			Log.error("[Mgr_BalanceEnquiryInputPage.java] Reset button is not found on Balance Enquiry Input page(Manager)");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Account Number Message Text
	public static WebElement accno_msgText() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_beip_accno_msgText_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[Mgr_BalanceEnquiryInputPage.java] Account Number Message Text is found on Balance Enquiry Input page(Manager)");
		} catch (Exception e) {
			Log.error("[Mgr_BalanceEnquiryInputPage.java] Account Number Message Text is not found on Balance Enquiry Input page(Manager)");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Heading Text
	public static WebElement heading_text() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_beip_heading_text_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[Mgr_BalanceEnquiryInputPage.java] Heading Text is found on Balance Enquiry Input page(Manager)");
		} catch (Exception e) {
			Log.error("[Mgr_BalanceEnquiryInputPage.java] Heading Text is not found on Balance Enquiry Input page(Manager)");
			e.printStackTrace();
		}
		return element;
	}
	
	// Building WebElement for Account No Text
	public static WebElement accno_text() {
		try {
			element_location = ReadPropertiesFile.getValue(Constants.UI_map_path, "mgr_beip_accno_text_xpath");
			element = driver.findElement(By.xpath(element_location));
			Log.info("[Mgr_BalanceEnquiryInputPage.java] Account No Text is found on Balance Enquiry Input page(Manager)");
		} catch (Exception e) {
			Log.error("[Mgr_BalanceEnquiryInputPage.java] Account No Text is not found on Balance Enquiry Input page(Manager)");
			e.printStackTrace();
		}
		return element;
	}

}
