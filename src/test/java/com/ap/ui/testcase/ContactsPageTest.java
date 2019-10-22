package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;

public class ContactsPageTest extends TestBase {
	
	ContactsPage contactsPage;
	HomePage homePage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUpDriver() {
		intialization();
		contactsPage = new ContactsPage(); 
		homePage = new HomePage();
	}
	
	@Test
	public void fillContactFormTest() {
		homePage.clickOnContactLink();
		contactsPage = contactsPage.fillContactForm("Customer Service", "abc@gmail.com", "Testing", "This is test purpose");
		
		contactsPage.submitMessage();
		String successMsg = contactsPage.getMessage();
		Assert.assertEquals(successMsg, "Your message has been successfully sent to our team.");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
