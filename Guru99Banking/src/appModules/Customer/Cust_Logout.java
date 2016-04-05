package appModules.Customer;

import com.guru99.pageObjects.Customer.Cust_HomePage;
import com.guru99.utils.Log;
import com.guru99.utils.Utilities;

public class Cust_Logout {
	
public static void execute() {
		
		Utilities.waitForElement(Cust_HomePage.logOut_link()).click();
		Log.info("[Cust_Logout.java] Clicked on Logout link");
		
		Utilities.waitForAlert().accept();
		Log.info("[Cust_Logout.java] Accepted the Logout alert");
	}

}
