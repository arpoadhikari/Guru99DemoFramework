package com.guru99.Tests;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.guru99.pageObjects.BasePage;
import com.guru99.utils.Constants;
import com.guru99.utils.ExcelUtil;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

//@Listeners(com.guru99.utils.TestNG_Listener.class)
public class BaseTest {
	
	public WebDriver driver = null;
	public ExcelUtil excel = null;
	public String actual_msg = null;
	public String expected_msg = null;
	public Method method = null;
	public String testMethodName = null;
	
	@BeforeTest
	public void init() throws Exception {
		DOMConfigurator.configure(Constants.Log4j_xml_path);
		driver = Utilities.startBrowser("firefox", Constants.URL);
		new BasePage(driver);
		excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.UI_Test_cases_sheet);
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
	public void endTestMethod(Method method) {
		Log.endTestCase(testMethodName);
	}
}
