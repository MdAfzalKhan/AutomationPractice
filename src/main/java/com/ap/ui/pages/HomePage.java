package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(id="contact-link")
	WebElement contactLink;
	
	@FindBy(id="search_query_top")
	WebElement searchField;
	
	@FindBy(css="[name='submit_search']")
	WebElement submitSearch;
	
	@FindBy(className="logout")
	WebElement logOutBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignIn() {
		signInBtn.click();
	}
	
	public void clickOnContactLink() {
		contactLink.click();
	}
	
	public void logOut() {
		logOutBtn.click();
	}
	
	public SearchPage searchProduct(String productName) {
		searchField.sendKeys(productName);
		searchField.click();
		return new SearchPage();
	}
	
}
