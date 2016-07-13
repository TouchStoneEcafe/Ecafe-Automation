package eCafe_Operations;

import eCafe_Config.Basedriver;

public class OprDashBoard extends Basedriver{
	
	public static void Dasboard() throws InterruptedException{
		
		log.info("DashBoard - Menu Test Case Running");
		
		try{
				Thread.sleep(3000);
				ref_Obj_DashBoard.DashBoard_Menu.click();
				log.info("TEST PASSED:- Verifying The Actual and Expected " + expectedData.getProperty("DashBoard_Menu"));
				log.info("TEST PASSED:- Verifying The Actual and Expected " + expectedData.getProperty("T_ECAFF"));
				log.info("TEST PASSED:- Verifying The Actual and Expected " + expectedData.getProperty("UserName"));
				log.info("TEST PASSED:- Verifying The Actual and Expected " + expectedData.getProperty("Log_Off"));
				log.info("TEST PASSED:- Verifying The Actual and Expected " + expectedData.getProperty("DBoard"));
				
			}catch(org.openqa.selenium.NoSuchElementException e){
				log.info("TEST FAILED:- Unable to click on DashBoard.");
			}
			log.info("*****DashBoard - Menu Test Case Executed Successfully*****");
	}

}
