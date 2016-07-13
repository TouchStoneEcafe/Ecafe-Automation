package Configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {
	 public static WebDriver Driver=null;
	 @BeforeSuite
	 public static void Project_Config(){
		 Driver=new FirefoxDriver();
	 }
	 
}
