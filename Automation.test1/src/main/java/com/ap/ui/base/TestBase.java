package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver = null;
	public static Properties properties = null;
	public static EventFiringWebDriver en_Driver = null;
	public static WebEventListener eventListener = null;
	
	public TestBase() {
		try {
			properties = new Properties();                                                //F:\\Projects_2_(26 Apr 2018)\\Automation.test1
			FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\ap\\ui\\config\\config.properties");
			properties.load(fileIn);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void intialization() {
		
		String driverPath = System.getProperty("user.dir");
		
		String browserName = properties.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath+"\\src\\main\\resources\\Drivers\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath+"\\src\\main\\resources\\Drivers\\geckodriver.exe");		
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", driverPath+"\\src\\main\\resources\\Drivers\\MicrosoftWebDriver.exe");		
			driver = new InternetExplorerDriver();
		}
		
		
		//creating object for action that's occurring and sharing with driver	
		en_Driver = new EventFiringWebDriver(driver);
		//create object of WebListener to register it with eventFiringWebdriver
		eventListener = new WebEventListener(); // 
		//event can be captured based on the method we create WebEventListener class
		en_Driver.register(eventListener); // put it in a register to captured events
		//since we know driver object is for browser en_driver is for event taking place. we declaring that they are
		//equal to each when they are exchanging the info
		
		driver = en_Driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicility_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
	}
	
}
