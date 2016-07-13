package eCafe_Config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import eCafe_Objects.ObjDashBoard;
import eCafe_Objects.ObjLoginPage;
import eCafe_Objects.ObjLogoutPage;
import eCafe_Operations.OprDashBoard;
import eCafe_Operations.OprLoginPage;
import eCafe_Operations.OprLogoutPage;

public class Basedriver {
		public static WebDriver Driver=null;
		
		//Object's 
		public static ObjLoginPage ref_Obj_loginPage;
		public static ObjLogoutPage ref_Obj_logoutPage;
		public static ObjDashBoard ref_Obj_DashBoard;
		
		//Operation's
		public static OprLoginPage ref_Opr_Login;
		public static OprLogoutPage ref_Opr_logoutPage;
		public static OprDashBoard ref_Opr_DashBoard;
		
		//LogFile
		public static Logger log = Logger.getLogger(Basedriver.class.getName());
		public static FileInputStream file=null;
		public static Properties expectedData=null;

		@BeforeTest
		@Parameters({ "browser" })
					public static void config(String browser) throws Exception {
						file=new FileInputStream(System.getProperty("user.dir")+"\\src\\eCafe_DDF\\ExpectedDatas.properties");
						expectedData=new Properties();
						expectedData.load(file);
						
					DOMConfigurator.configure("log4j.xml");
					
					if(browser.equalsIgnoreCase("firefox")){
						 Driver=new FirefoxDriver();
						 log.info("***** Opening Firefox Browser *****");
					}
					else if(browser.equalsIgnoreCase("chrome")){
						System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
						 Driver=new ChromeDriver();
						 log.info("***** Opening Chrome Browser *****");
					}
					else{
						DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
						capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
						System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
						Driver=new InternetExplorerDriver(capabilities);	
						log.info("***** Opening IE Browser *****");
					}
					
			//Wait for Driver
				Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Driver.manage().window().maximize();
				
			// Object Reference Initialization
				ref_Obj_loginPage = new ObjLoginPage(Driver);
				ref_Obj_logoutPage = new ObjLogoutPage(Driver);
				ref_Obj_DashBoard = new ObjDashBoard(Driver);
				
			// Operations Reference Initialization
				ref_Opr_Login = new OprLoginPage();
				ref_Opr_logoutPage = new OprLogoutPage();
				ref_Opr_DashBoard = new OprDashBoard();
				
				log.info(" ");
				log.info("************************************************** ");
				log.info("TestCase Execution Starts for ECafe Project");
				log.info("************************************************** ");
	}
				@AfterTest
				public static void closeDriver(){
					log.info(" ");
					log.info("TestCase Execution Finished for ECafe Project");
					log.info("Closing Driver");
					Driver.close();
				 }
			
}
