package eCafe_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCafe_Operations.OprLogoutPage;

public class ObjLogoutPage extends OprLogoutPage{
		public ObjLogoutPage(WebDriver Driver){
		PageFactory.initElements(Driver, this);
	}
		// LOGOUT PAGE FOR eCafe...
		@FindBy(xpath="//*[@id='logoutForm']/ul/li[2]/a")
		public static WebElement LogOff;
}

