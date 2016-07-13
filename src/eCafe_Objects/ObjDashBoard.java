package eCafe_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCafe_Operations.OprDashBoard;
import eCafe_Operations.OprLogoutPage;

public class ObjDashBoard extends OprDashBoard {
	
	public ObjDashBoard(WebDriver Driver){
		PageFactory.initElements(Driver, this);
	}
	
	// DashBoard - Menu Page FOR eCafe...
			@FindBy(xpath="//*[@id='menu-content']/li[1]/a")
			public static WebElement DashBoard_Menu;

}
