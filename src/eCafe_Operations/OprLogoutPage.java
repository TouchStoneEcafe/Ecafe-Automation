package eCafe_Operations;

import eCafe_Config.Basedriver;

public class OprLogoutPage extends Basedriver{
	
	// LogOut to the Highplains.com
		public static void logoutPage() throws InterruptedException{
			
			log.info("Logout Test Case Running");
			try{
				Thread.sleep(3000);
				ref_Obj_logoutPage.LogOff.click();
				log.info("TEST PASSED:- The Actual and Expected "+ expectedData.getProperty("LogOff"));
			}catch(org.openqa.selenium.NoSuchElementException e){
				log.info("TEST FAILED:- Unable to click on LogOff button.");
			}
			log.info("*****LogOut - Test Case Executed Successfully*****");
		}
}
