package eCafe_Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods extends Basedriver{
	public static WebDriverWait wait;
	public static String GetStringOfWebElement(WebElement xpath) {
		int strLen;
		int startIndex;
		
		String strXpath=xpath.toString();
		//System.out.println(xpath);
		 strLen=xpath.toString().length()-1;
		startIndex=strXpath.indexOf("-> ");
		strXpath=strXpath.substring(startIndex, strLen);
		//System.out.println(strXpath);
		
		strLen=strXpath.toString().length();
		startIndex=strXpath.indexOf(": ")+2;
		strXpath=strXpath.substring(startIndex, strLen);
		//System.out.println(strXpath);
		return strXpath;
}
	public static void clickAnElement(WebElement xpath) {
		String convertXpath=GetStringOfWebElement(xpath);
		 wait = new WebDriverWait(Driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(convertXpath)));
	    Driver.findElement(By.xpath(convertXpath)).click();
	}
	
	public static void clickAnElement(String xpath) {
		wait = new WebDriverWait(Driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    Driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void SendKeys(WebElement xpath, String sendKeys) {
		String convertXpath=GetStringOfWebElement(xpath);
		 wait = new WebDriverWait(Driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(convertXpath)));
	    Driver.findElement(By.xpath(convertXpath)).sendKeys(sendKeys);
	}
	
	public static void SendKeys(String xpath, String sendKeys) {
		wait = new WebDriverWait(Driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    Driver.findElement(By.xpath(xpath)).sendKeys(sendKeys);
	}
	
	public static WebElement FindAnElement(String xpath) {
		wait = new WebDriverWait(Driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    return Driver.findElement(By.xpath(xpath));
	    
	}
}
