package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class LoginPageTestCases extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	//calling the superclass constructor
	public LoginPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUpDriver() {
		intialization();
		loginPage = new LoginPage(); 
	}
	@Test(priority=1)
	public void logingPageTitleTest() {
		String title = loginPage.verifyPageTitle();
		Assert.assertEquals(title, "Login - My Store");
	}
	@Test(priority=2)
	public void apLogoTest() {
		boolean logo = loginPage.validateAPImage();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void logInTest() {
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
