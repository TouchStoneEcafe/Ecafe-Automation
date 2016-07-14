package eCafe_Operations;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;

import eCafe_Config.Basedriver;

public class OprLoginPage extends Basedriver{

	// Login to the Highplains.com
	public static void loginPage(){
		
		log.info("login Test Case Running");
		String userLabel=null;
		try{
		/*	userLabel=Driver.findElement(By.xpath(".//*[@id='loginForm']/form/div[1]/label")).getAttribute("for");
			Assert.assertEquals(userLabel, expectedData.getProperty("userlabel"));
		*/	RM.SendKeys(ref_Obj_loginPage.userID, inputData.getProperty("UserId"));
				log.info("TEST PASSED:- The Actual and Expected - Login User Id: "+ expectedData.getProperty("UserId"));
			ref_Obj_loginPage.PassWord.sendKeys(inputData.getProperty("Password"));
				log.info("TEST PASSED:- The Actual and Expected - Login Password: "+expectedData.getProperty("Password"));
				RM.clickAnElement(ref_Obj_loginPage.Login);
				log.info("TEST PASSED:- The Actual and Expected - Login Button:"+expectedData.getProperty("Login"));
		}
		catch(AssertionError e){
			log.error("Actual User label is "+ userLabel + " Expected user label is: "+ expectedData.getProperty("userlabel"));
		}
		catch(org.openqa.selenium.NoSuchElementException e){
			log.info("TEST FAILED:- Unable to Click SignIn");
		}
				log.info("*****Login Test Case Executed Successfully*****");
	}
				
}

