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
		try{
			ref_Obj_loginPage.userID.sendKeys(expectedData.getProperty("UserId"));
				log.info("TEST PASSED:- The Actual and Expected - Login User Id: "+ expectedData.getProperty("UserId"));
			ref_Obj_loginPage.PassWord.sendKeys(expectedData.getProperty("Password"));
				log.info("TEST PASSED:- The Actual and Expected - Login Password: "+expectedData.getProperty("Password"));
			ref_Obj_loginPage.Login.click();
				log.info("TEST PASSED:- The Actual and Expected - Login Button:"+expectedData.getProperty("Login"));
		}catch(org.openqa.selenium.NoSuchElementException e){
			log.info("TEST FAILED:- Unable to Click SignIn");
		}
				log.info("*****Login Test Case Executed Successfully*****");
	}
				
}

