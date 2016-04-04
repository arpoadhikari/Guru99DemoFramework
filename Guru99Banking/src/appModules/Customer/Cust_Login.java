package appModules.Customer;

import com.guru99.pageObjects.LoginPage;
import com.guru99.utils.Constants;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

public class Cust_Login {

public static void execute() {
		
		Utilities.waitForElement(LoginPage.userID_input()).sendKeys(Constants.Customer_uid);
		Log.info("[Cust_Login.java] Customer's UserID is entered in userID input box");
		
		Utilities.waitForElement(LoginPage.password_input()).sendKeys(Constants.Customer_pwd);
		Log.info("[Cust_Login.java] Manager's password is entered in userID input box");
		
		Utilities.waitForElement(LoginPage.login_button()).click();
		Log.info("[Cust_Login.java] Clicked on Login button");

	}
}
