package TestCase;

import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

import CommonPackage.CommonFunctions;
import PageObjects.Login_Page;
import PageObjects.user_rolepageobjects;

public class pendingleaverequest extends CommonFunctions {
	
	
	public void login() {
		Login_Page.username.sendKeys("maheshbabu@captechin.com");
		Login_Page.password.sendKeys("12345@Test");
		Login_Page.submit.click();
		
	}
	public void SearchAdminUser() {
		
		
		user_rolepageobjects.admin.click();
	}
	
	
	@Test
	public void verifyPendingLeaverequest() {
		login();
		
		
		
		
	}

}
