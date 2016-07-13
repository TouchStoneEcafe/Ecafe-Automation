package eCafe_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCafe_Operations.OprLoginPage;

		public class ObjLoginPage extends OprLoginPage{
			public ObjLoginPage(WebDriver Driver){
				PageFactory.initElements(Driver, this);
			}
			
			// lOGIN PAGE FOR HIGHPLAINS
			/*@FindBy(xpath="//*[@id='loginLink']")
			public static WebElement loginLink;*/
			
			@FindBy(xpath="//*[@id='UserId']")
			public static WebElement userID;
			
			@FindBy(xpath="//*[@id='Password']")
			public static WebElement PassWord;
			
			@FindBy(xpath="//*[@id='loginForm']/form/div[4]/div/input")
			public static WebElement Login;
}

