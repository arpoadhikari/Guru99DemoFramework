package com.guru99.Tests.UI_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appModules.Manager.Mgr_Login;
import appModules.Manager.Mgr_Logout;

import com.guru99.Tests.BaseTest;
import com.guru99.pageObjects.Manager.Mgr_BalanceEnquiryInputPage;
import com.guru99.pageObjects.Manager.Mgr_HomePage;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

public class BalanceEnquiry_Form extends BaseTest{
	
	// Account No. must not be blank
	@Test  (enabled = true)
	public void T30() {
		Mgr_Login.execute();
		Log.info("[BalanceEnquiry_Form.java] Logged in as manager");
		Mgr_HomePage.balEnquiry_link().click();
		Log.info("[BalanceEnquiry_Form.java] Clicked on Balance Enquiry link");
		Mgr_BalanceEnquiryInputPage.accno_input().sendKeys("");
		Log.info("[BalanceEnquiry_Form.java] Blank text provided in the Account No. input box");
		Mgr_BalanceEnquiryInputPage.accno_text().click();
		Log.info("[BalanceEnquiry_Form.java] Clicked on other web element to switch the focus");
		actual_msg = Mgr_BalanceEnquiryInputPage.accno_msgText().getText();
		Log.info("[BalanceEnquiry_Form.java] Got the actual message text for the Account No. input box");
		expected_msg = Utilities.getExpectedMsg(testMethodName);
		Log.info("[BalanceEnquiry_Form.java] Got the expected message text for the Account No. input box");
		Assert.assertEquals(actual_msg, expected_msg, "Expected message for blank Account No. didn't come.");
		Mgr_Logout.execute();
		Log.info("[BalanceEnquiry_Form.java] Logged out from manager");
	}
	
	@Test (enabled = true)
	public void T31() {
		Mgr_Login.execute();
		Log.info("[BalanceEnquiry_Form.java] Logged in as manager");
		Mgr_Logout.execute();
		Log.info("[BalanceEnquiry_Form.java] Logged out from manager");
	}
	
	@Test  (enabled = false)
	public void T32() {
		Mgr_Login.execute();
		Log.info("[BalanceEnquiry_Form.java] Logged in as manager");
		Mgr_Logout.execute();
		Log.info("[BalanceEnquiry_Form.java] Logged out from manager");
	}

}
