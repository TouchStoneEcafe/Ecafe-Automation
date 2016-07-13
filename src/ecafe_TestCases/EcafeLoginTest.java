package ecafe_TestCases;

import org.testng.annotations.Test;

import Configurations.BaseDriver;

public class EcafeLoginTest extends BaseDriver{
	@Test
	public static void LoginFunctionality(){
		Driver.get("http://192.2.200.2:72/testecafevnext/Auth/Login");
	}
}
