package appModules.Manager;

import com.guru99.pageObjects.LoginPage;
import com.guru99.utils.Constants;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

public class Mgr_Login {
	
	public static void execute() {
		
		Utilities.waitForElement(LoginPage.userID_input());
		LoginPage.userID_input().sendKeys(Constants.Manager_uid);
		Log.info("[Mgr_Login.java] "+Constants.Manager_uid+" is entered in userID input box");
		
		Utilities.waitForElement(LoginPage.password_input());
		LoginPage.password_input().sendKeys(Constants.Manager_pwd);
		Log.info("[Mgr_Login.java] "+Constants.Manager_pwd+" is entered in userID input box");
		
		Utilities.waitForElement(LoginPage.login_button());
		LoginPage.login_button().click();
		Log.info("[Mgr_Login.java] Clicked on Login button");

	}

}
