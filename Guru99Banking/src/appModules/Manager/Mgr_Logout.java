package appModules.Manager;

import com.guru99.pageObjects.Manager.Mgr_HomePage;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

public class Mgr_Logout {
	
	public static void execute() {
		
		Utilities.waitForElement(Mgr_HomePage.logOut_link());
		Mgr_HomePage.logOut_link().click();
		Log.info("[Mgr_Logout.java] Clicked on Logout link");
		
		Utilities.waitForAlert();
		Mgr_HomePage.logOut_alert().accept();
		Log.info("[Mgr_Logout.java] Accepted the Logout alert");
	}

}
