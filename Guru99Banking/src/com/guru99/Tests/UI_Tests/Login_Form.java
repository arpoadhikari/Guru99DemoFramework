package com.guru99.Tests.UI_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.Tests.BaseTest;
import com.guru99.pageObjects.LoginPage;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

public class Login_Form extends BaseTest{
	
	@Test
	public void T92() throws Exception {
		
		LoginPage.userID_input().sendKeys("");
		Log.info("[Login_Form.java] Blank text provided in the UserID input box");
		LoginPage.password_input().click();
		Log.info("[Login_Form.java] Clicked on Password input box to switch the focus");
		actual_msg = LoginPage.userId_msgText().getText();
		Log.info("[Login_Form.java] Got the message text for the UserID input box");
		expected_msg = Utilities.getExpectedMsg(testMethodName);
		Utilities.refreshPage();
		Log.info("[Login_Form.java] Page refreshed");
		Assert.assertEquals(actual_msg, expected_msg, "Expected message for blank User-ID didn't come.");
	}
	
	@Test
	public void T93() throws Exception {
		
		LoginPage.password_input().sendKeys("");
		Log.info("[Login_Form.java] Blank text provided in the Password input box");
		LoginPage.userID_input().click();
		Log.info("[Login_Form.java] Clicked on UserID input box to switch the focus");
		actual_msg = LoginPage.password_msgText().getText();
		Log.info("[Login_Form.java] Got the message text for the Password input box");
		expected_msg = Utilities.getExpectedMsg(testMethodName);
		Utilities.refreshPage();
		Log.info("[Login_Form.java] Page refreshed");
		Assert.assertEquals(actual_msg, expected_msg, "Expected message for blank Password didn't come.");
	}

}
