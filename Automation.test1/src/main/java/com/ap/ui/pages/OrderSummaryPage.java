package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class OrderSummaryPage extends TestBase {
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedCheckOutBtn;
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement processAddressBtn;
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement ProcessCarrierBtn;
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement termsAndConditon;
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement payByBankWire;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrder;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement orderConfirm;
	
	public  OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage proceedCheckOut() {
		proceedCheckOutBtn.click();
		return this;
	}
	
	public OrderSummaryPage proceedAddressCheckOut() {
		processAddressBtn.click();
		return this;
	} 
	
	public OrderSummaryPage proceedCarrierCheckOut() {
		termsAndConditon.click();
		ProcessCarrierBtn.click();
		return this;
	} 
	
	public OrderSummaryPage confirmOrder() {
		payByBankWire.click();
		confirmOrder.click();
		return this;
	} 
	
	public String getConfirmationMessage() {
		return orderConfirm.getText();
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
