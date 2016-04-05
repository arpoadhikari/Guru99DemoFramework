package com.guru99.Tests;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import appModules.Customer.Cust_Logout;
import appModules.Manager.Mgr_Logout;

import com.guru99.pageObjects.BasePage;
import com.guru99.utils.Constants;
import com.guru99.utils.ExcelUtil;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

//@Listeners(com.guru99.utils.TestNG_Listener.class)
public class BaseTest {
	
	public WebDriver driver = null;
	public String actual_msg = null;
	public String expected_msg = null;
	public Method method = null;
	public String testMethodName = null;
	
	@BeforeTest
	public void init() throws Exception {
		DOMConfigurator.configure(Constants.Log4j_xml_path);
		driver = Utilities.startBrowser("firefox", Constants.URL);
		new BasePage(driver);
		new ExcelUtil(Constants.UI_Test_cases_path, Constants.UI_Test_cases_sheet);
	}
	
	@AfterTest
	public void tear_down() {
		Utilities.closeBrowser();
	}
	
	@BeforeMethod
	public void startTestMethod(Method method) throws Exception {
		testMethodName = method.getName();
		Log.startTestCase(testMethodName);
	}
	
	@AfterMethod
	public void endTestMethod() {
		if (Utilities.chk_LoginStatus().equalsIgnoreCase("manager")) {
			Mgr_Logout.execute();
			Log.info("[BaseTest.java] Logged out as manager");
		}
		else if (Utilities.chk_LoginStatus().equalsIgnoreCase("customer")) {
			Cust_Logout.execute();
			Log.info("[BaseTest.java] Logged out as customer");
		}
		Log.endTestCase(testMethodName);
	}
	
	@DataProvider(name = "CharSet")
	public Object[][] test_CharSet() throws Exception {
		ExcelUtil excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.charSet_sheet);
		int rows = excel.getLastRow();
		String[][] dataArray = new String[rows][1];
		for (int i = 0; i < rows; i++) {
			dataArray[i][0] = excel.readCell(i+1, Constants.charSet_col);
		}
		return dataArray;
	}
	
	@DataProvider(name = "SpclCharSet")
	public Object[][] test_SpclCharSet() throws Exception {
		ExcelUtil excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.charSet_sheet);
		int rows = excel.getLastRow();
		String[][] dataArray = new String[rows][1];
		for (int i = 0; i < rows; i++) {
			dataArray[i][0] = excel.readCell(i+1, Constants.spclCharSet_col);
		}
		return dataArray;
	}
}
