package com.guru99.Tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import appModules.Manager.Mgr_Login;
import appModules.Manager.Mgr_Logout;

import com.guru99.pageObjects.BasePage;
import com.guru99.pageObjects.LoginPage;
import com.guru99.utils.Constants;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;
import com.guru99.utils.ExcelUtil;

public class SampleTest {

	@Test (enabled = false)
	public void T92() throws Exception {
		
		DOMConfigurator.configure(Constants.Log4j_xml_path);
		WebDriver driver = Utilities.startBrowser("firefox", Constants.URL);
		new BasePage(driver);
		//ExcelUtil excel = new ExcelUtil(Constants.UI_Test_cases_path, Constants.UI_Test_cases_sheet);
		//System.out.println(excel.readCell(1, Constants.TCID_col));
		//System.out.println(this.getClass().getMethod("T92").getName());
		Log.startTestCase(this.toString());
		Log.info("New driver instantiated");
		LoginPage.userID_input().sendKeys(Constants.Manager_uid);
		Utilities.highlightWebElement(LoginPage.userID_input());
		Thread.sleep(2000);
		LoginPage.password_input().sendKeys(Constants.Manager_pwd);
		LoginPage.login_button().click();        
        Utilities.closeBrowser();
        Log.info("Browser closed");  
        System.out.println("Test Completed");
        Log.endTestCase(this.toString());
	
	}
	@Test
	public void F1() {
		
		DOMConfigurator.configure(Constants.Log4j_xml_path);
		WebDriver driver = Utilities.startBrowser("firefox", Constants.URL);
		new BasePage(driver);
		Mgr_Login.execute();
		Mgr_Logout.execute();
		Utilities.closeBrowser();
		
	}

}
