package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.SearchPage;

public class SearchItemTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	
	public SearchItemTest() {
		super();
	}
	
	@BeforeMethod
	public void setUpdriver() {
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		
	}
	@Test(priority=3)
	public void testSerachItem() {
		String product = "Evening";
		homePage.clickOnSignIn();
		homePage = loginPage.login(properties.getProperty("password"), properties.getProperty("password"));
		
		searchPage = homePage.searchProduct(product);
		String header = searchPage.getHeader();
		System.out.println(header);
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		homePage.logOut();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}


