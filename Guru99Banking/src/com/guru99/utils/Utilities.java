package com.guru99.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Utilities {

	static WebDriver driver = null;
	static WebDriverWait wait = null;
	
	// Launch the browser
	public static WebDriver startBrowser(String browserName, String url) {
		
		if ( driver == null) {
			try {
				if(browserName.equalsIgnoreCase("firefox")) {			
					driver = new FirefoxDriver();
					Log.info("[Utilities.java] New FirefoxDriver instantiated");
				}
				else if(browserName.equalsIgnoreCase("chrome")) {			
					// TO DO
					driver = new ChromeDriver();
					Log.info("[Utilities.java] New ChromeDriver instantiated");
				}
				else if(browserName.equalsIgnoreCase("IE")) {			
					// TO DO
					driver = new InternetExplorerDriver();
					Log.info("[Utilities.java] New InternetExplorerDriver instantiated");
				}		
				driver.manage().window().maximize();
				driver.get(url);
				Log.info("[Utilities.java] Web application launched successfully");
			} 
			catch (Exception e) {
				Log.error("[Utilities.java] ERROR in launching web application");
				e.printStackTrace();
			}
		}
		return driver;
			
	}
	
	//Refresh the WebPage
	public static WebDriver refreshPage() {
		driver.navigate().refresh();
		return driver;
	}
	
	// Close the browser
	public static void closeBrowser() {
		try {
			driver.close();
			driver.quit();
			Log.info("[Utilities.java] Web application closed successfully");
		} catch (Exception e) {
			Log.error("[Utilities.java] ERROR in closing web application");
			e.printStackTrace();
		}
	}
	
	// Wait for WebElement
	public static WebElement waitForElement(WebElement element) {
		 
		 wait = new WebDriverWait(driver, 10);
	     return wait.until(ExpectedConditions.visibilityOf(element));
	     
	 }
	
	// Wait for Alert
	public static Alert waitForAlert() {
			 
		wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.alertIsPresent());
		     
	}
	
	// Highlight WebElement
	public static void highlightWebElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px groove green'", element);
	}
	
	// Capture Screenshots
	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception {
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constants.Path_ScreenShot + sTestCaseName +".jpg"));	
			Log.info("[Utilities.java] ScreenShot captured");
		} catch (Exception e){
			Log.error("[Utilities.java] Exception occured while capturing ScreenShot");
			e.printStackTrace();
		}
	}
	
	// Method to get Runmode from the Test case doc
	public static boolean getRunmode(String testID) throws Exception {
		String runMode = null;
		try {
			ExcelUtil excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.UI_Test_cases_sheet);
			runMode = excel.readCell(excel.findValue(testID).get(0).getRowIndex(), Constants.RunMode_col);
		} catch (Exception e) {
			Log.error("[Utilities.java] Failed to get Run Mode from excel file");
			e.printStackTrace();
		}
		if (runMode.equalsIgnoreCase("Y"))
			return true;
		else
			return false;
	}
	
	// Method to set test result in excel
	public static void setTestResult(String testID, String testResult) {
		try {
			ExcelUtil excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.UI_Test_cases_sheet);
			excel.writeCell(testResult, excel.findValue(testID).get(0).getRowIndex(), Constants.Result_col);
		} catch (Exception e) {
			Log.error("[Utilities.java] Failed to set Test Result in excel file");
			e.printStackTrace();
		}
	}
	
	// Method to set time stamp in excel
	public static void setTimeStamp(String testID) {
		try {
			ExcelUtil excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.UI_Test_cases_sheet);
			Date date = new Date();
			excel.writeCell(date.toString(), excel.findValue(testID).get(0).getRowIndex(), Constants.Time_col);
		} catch (Exception e) {
			Log.error("[Utilities.java] Failed to set time-stamp in excel file");
			e.printStackTrace();
		}
	}
	
	// Method to get Expected Text Message from the Test case doc
	public static String getExpectedMsg(String testID) {
		String exp_msg = null;
		try {
			ExcelUtil excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.UI_Test_cases_sheet);
			exp_msg = excel.readCell(excel.findValue(testID).get(0).getRowIndex(), Constants.exp_msg_col);
		} catch (Exception e) {
			Log.error("[Utilities.java] Failed to get expected message from excel file");
			e.printStackTrace();
		}
		return exp_msg;
	}
	
}
