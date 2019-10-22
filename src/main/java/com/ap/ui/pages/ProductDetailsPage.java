package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPage extends TestBase {
	
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement t_Shirt;
	
	@FindBy(id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(id="group_1")
	WebElement sizeDropDown;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addToCart;
	
	@FindBy(id="wishlist_button")
	WebElement addWishListBtn;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedCheckOut;
	
	@FindBy(className="fancybox-item fancybox-close")
	WebElement addWishListMscloseBtn;
	
	
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAddWishListMsg() {
		Assert.assertEquals(addWishListBtn.getText(), "Added to your wishlist");
		addWishListMscloseBtn.click();
	}
	
	public ProductDetailsPage selectProductColor(String color) {
		String locator = "[name='" + color + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	
	public ProductDetailsPage inputQuantuty(String quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this; //will handle different color (will be repeated over and over again with set of different data)
	}
	
	public ProductDetailsPage selectSize(String size) {
		Select select = new Select(sizeDropDown);
		select.selectByVisibleText(size);
		return this;
	}
	
	public ProductDetailsPage clickAddCart() {
		addToCart.click();
		return this;
	}
	
	public ProductDetailsPage clickAddWishListBtn() {
		addWishListBtn.click();
		return this;
	}
	
	public OrderSummaryPage proceedCheckOut() {
		proceedCheckOut.click();
		return new OrderSummaryPage();
	}
	


}
