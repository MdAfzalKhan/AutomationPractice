package com.ap.ui.ExtentReport.Listener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//implement IReporter under testng
public class ExtentReporterN implements IReporter {
	
	private ExtentReports extent;
	
	//implementing method from IReporter
	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> suites, String outPutDirectory) {
		
		//assign ExtentReports object into extent reference from class variable earlier
		//all output of File.separator is need if different machine 
		extent = new ExtentReports(outPutDirectory + File.separator + "Extent.html", true); //true if don't have report from test script don't generate report
		
		for(ISuite suite : suites) {//ISuite is a interface define Test Suite
			Map<String, ISuiteResult> result = suite.getResults(); //can't contain duplicate values and map it into a location
		
		for(ISuiteResult r : result.values() ) {
			ITestContext context = r.getTestContext();
			
			buildTestNodes(context.getPassedTests(), LogStatus.PASS);
			buildTestNodes(context.getPassedTests(), LogStatus.FAIL);
			buildTestNodes(context.getPassedTests(), LogStatus.SKIP);
			
		}
	}
		//adding the result and attach the result to HTML file that script have
	extent.flush(); 
	//after adding the result close the report 
	extent.close();
	
}
	
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		
		if(tests.size()>0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for(String group : result.getMethod().getGroups())
					test.assignCategory(group);
				
				if (result.getThrowable()!=null) {
					test.log(status, result.getThrowable());
				}else {
					test.log(status, "Test " + status.toString().toLowerCase() + " ed");
				}
				extent.endTest(test);
			}
		}
	}
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
		
	}

}

