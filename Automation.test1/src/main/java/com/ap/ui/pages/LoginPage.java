package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPage extends TestBase {

	//page factory object repository
	@FindBy(id="email")
	WebElement userName;

	@FindBy(id="passwd")
	WebElement pssd;

	@FindBy(xpath="//p[@class='submit']//span[1]")
	WebElement signInBtn;

	@FindBy(xpath="")
	WebElement apLogo;


	//initialize webelement inside constructor
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public boolean validateAPImage() {
		return apLogo.isDisplayed();
	}


	public HomePage login(String uname, String passw) {
		userName.sendKeys(uname);
		pssd.sendKeys(passw);
		signInBtn.click();
		return new HomePage();
	}



}
