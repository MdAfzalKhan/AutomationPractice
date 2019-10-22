//We have created this class WebEventListener in order to implement interface  (WebDriverEventListener)
// is to override all the methods and define certain helpful log  actions  which would 
//be displayed/logged as the app under test is being executed. These methods will be invoked
//by itself automatically when certain actions are performed. Ex: click, submit, screenshot, findby, etc.


package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeNavigate(String url, WebDriver driver) {
		System.out.println("Before navigate to : '" + url + " ' ");
	}

	public void afterNavigate(String url, WebDriver driver) {
		System.out.println("Navigate to : '" + url + " ' ");
	}

	public void beforeChangeValueof(WebElement element, WebDriver driver) {
		System.out.println("Value of : " + element.toString() + " before making any change");
	}

	public void aftereChangeValueof(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to : " + element.toString());
	}

	public void beforeClickingOn(WebElement element, WebDriver driver) {
		System.out.println("Attempting to Click on : " + element.toString());
	}

	public void afterClickingOn(WebElement element, WebDriver driver) {
		System.out.println("Successfully Clicked on : " + element.toString());
	}

	public void beforeNavigatingBack(WebDriver driver) {
		System.out.println("Attempting Navigating back to previous page");
	}

	public void afterNavigatingBack(WebDriver driver) { 
		System.out.println("Successfully Navigating to current page");
	}

	public void beforeNavigatingForward(WebDriver driver) {
		System.out.println("Attempting Navigating forward to next page");
	}

	public void afterNavigatingForward(WebDriver driver) {
		System.out.println("Successfully Navigating forward to next page");
	}

	public void dueToException(Throwable error, WebDriver driver) throws IOException {
		System.out.println("Exception occured : " + error);
		TestUtil.takeScreenshotAt();
		
	}

		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Attempting to find the element : " + by.toString());

		}

		public void afterFindBy(By by, WebElement element, WebDriver driver) {
			System.out.println("Successfully  found the element : " + by.toString());

		}

		//These are non overridden methods of the WebListener class
		public void beforeScript(String script, WebDriver driver) {

		}
		public void afterScript(String script, WebDriver driver) {

		}
		public void beforeAcceptingAlert(WebDriver driver) {

		}

		public void afterAcceptingAlert(WebDriver driver) {

		}

		public void beforeDismissingAlert(WebDriver driver) {

		}

		public void afterDismissingAlert(WebDriver driver) {

		}

		public void beforeNavigateRefresh(WebDriver driver) {

		}

		public void afterNavigateRefresh(WebDriver driver) {

		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence [] keysToSend) {

		}

		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence [] keysToSend) {

		}

		public <X> void beforeGetScreenshotAs(OutputType<X>arg0) {

		}

		public <X> void aftereGetScreenshotAs(OutputType<X>arg0, X arg1) {

		}

		public void beforeGetText(WebElement arg0, WebDriver arg1) {

		}
		public void aftereGetText(WebElement arg0, WebDriver arg1, String arg2) {

		}
		
		public void beforeSwitchToWindow(String arg0, WebDriver arg1) {

		}
		
		public void afterSwitchToWindow(String arg0, WebDriver arg1) {

		}
		
		
		//add unimplemented method

		public void beforeAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterAlertAccept(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeAlertDismiss(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeNavigateTo(String url, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterNavigateTo(String url, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeNavigateBack(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterNavigateBack(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeNavigateForward(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterNavigateForward(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void beforeClickOn(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void afterClickOn(WebElement element, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public void onException(Throwable throwable, WebDriver driver) {
			// TODO Auto-generated method stub
			
		}

		public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
			// TODO Auto-generated method stub
			
		}

		public void afterGetText(WebElement element, WebDriver driver, String text) {
			// TODO Auto-generated method stub
			
		}

	}
