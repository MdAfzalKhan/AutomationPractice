package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.ProductDetailsPage;
import com.ap.ui.pages.SearchPage;

public class AddWishlistTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;

	public AddWishlistTest() {
		super();
	}

	@BeforeMethod
	public void setUpdriver() {
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Test
	public void testAddProductToWishList() {
		String product = "Printed Chiffon Dress";
		homePage.clickOnSignIn();
		homePage = loginPage.login(properties.getProperty("password"), properties.getProperty("password"));

		searchPage = homePage.searchProduct(product);
		String header = searchPage.getHeader();
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));

		productDetailsPage.clickAddWishListBtn();
		productDetailsPage.verifyAddWishListMsg();
		homePage.logOut();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
