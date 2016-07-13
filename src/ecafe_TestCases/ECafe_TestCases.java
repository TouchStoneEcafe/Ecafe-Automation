package eCafe_Testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import eCafe_Config.Basedriver;
import eCafe_Objects.ObjLoginPage;
import eCafe_Operations.OprLoginPage;

public class ECafe_TestCases extends Basedriver{

	//TestCase for Login ECAFEE Site
	@BeforeTest
	public static void Login_Ec()throws InterruptedException {
		log.info("");
		log.info("_____________________________________________________________________");
		log.info("*** TestCase - LoginPage ***");
		log.info("_____________________________________________________________________");
		Driver.get("http://192.2.200.2:72/testecafevnext/Auth/Login");
		ref_Opr_Login.loginPage();
	}
	
	//Test Case - 02
	@Test 
	public static void Dasboard() throws InterruptedException {
		
		log.info("*** TestCase - DashBoard - Menu List ***");
		log.info("_____________________________________________________________________");
		ref_Opr_DashBoard.Dasboard();
	}
	

   // Logout ECAFEE Site
	@AfterTest
	public static void LogoutPage() throws InterruptedException {
		log.info("");
		log.info("_____________________________________________________________________");
		log.info("*** TestCase - LogOutPage ***");
		log.info("_____________________________________________________________________");
		ref_Opr_logoutPage.logoutPage();
	}
	
	public static void Logout_Ec() throws InterruptedException{
		log.info("Signing Out");
	}
}
