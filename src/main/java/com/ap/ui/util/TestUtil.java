package com.ap.ui.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException; // try catch was unreachable
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long Page_Load = 10;
	public static long Implicility_Wait = 10;
	
	
	public static String XL_SHEET_PATH = "";
	
	static Workbook wbook;
	static Sheet sheet;
	static JavascriptExecutor js = null;
	
	
	//method to read data from excel file and pass it to script
	public static Object [][] getTestData(String sheetName) throws EncryptedDocumentException, InvalidFormatException { // more data field need more dimension in array
		
		//handle files in machine with which script communicates 
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(XL_SHEET_PATH);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wbook = WorkbookFactory.create(fileIn);
			/*
		}catch (InvalidException e) { //import it from log4j
			// TODO: handle exception
			 * 
			 */
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//get to sheet using sheetName as argument
		sheet = wbook.getSheet(sheetName);
		
		// create two dimensional array and provide dimension for array object using lastRowNum and getLastCellNum
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAt() throws IOException {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentUserDir = System.getProperty("user.dir");
		
		//second argument also keeping date and time of when screenshot is taken 
		FileUtils.copyFile(srcFile, new File(currentUserDir + "/screenshot/" + System.currentTimeMillis() + " .png"));
		
	}
	
	//jquery 
	//basically software has front=javscript,css,jquery backend=
	//capturing what is happening in my script
	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		//casting driver to JavascriptExecutor
		js = (JavascriptExecutor) driver;
		js.executeScript("if (!window.JQuery){" 
	    + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';" 
		+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
		+"document.getElementsByTagName('head')[0]).appendChild(jquery);" + "}");
		
		//information getting and then translate to script that is why wait is after each method
		Thread.sleep(6000);
		
		
		//javascript is using website link to use that website and process information with the help of this  
		
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery/.growl.js');");
				
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
						+ "href=\"https://the-internet.herokauapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');" );
		
		Thread.sleep(6000);
		
		js.executeScript("$growl({title:'GET', message: '/'});"); //generic logic for exception, error, notice and warning
				
		if (messageType.equals("error")) {
			js.executeScript("$growl.error({ title: 'ERROR' message: '" + message + "'});");
			
		}else if (messageType.equals("info")) {
			js.executeScript("$growl.error({ title: 'Notice', message: 'notice message will appear here'});");
			
		
	    }else if (messageType.equals("Warning")) {
		js.executeScript("$growl.WarningWarning({ title: 'Warning!!', message: 'your warning message will appear here'});");
		
	   }else {
		System.out.println("Show no Error Message");
		Thread.sleep(6000);
		
	   }
	}	
		
}
