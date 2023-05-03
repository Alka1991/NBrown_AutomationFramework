package com.cname.nbrown.TestInitialization;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.cname.core.framework.datalayer.ExcelDriver;
import com.cname.core.framework.webcomponent.WebButton;
import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;

public class TestInitializationScript 
{
	public SeWebDriver seWDriver = new SeWebDriver();
	public SeWebElement seWElm = new SeWebElement();
	public ExcelDriver excel = new ExcelDriver();
	public WebButton wb = new WebButton();
	
	
	
	@AfterMethod
	public void tearDown(ITestResult itr)
	{
		String val = getTestResult(itr);
		if(val.equals("FAIL"))
		{
			String testName = itr.getMethod().getMethodName();
			seWDriver.caputureScreenshot(testName);
		}
	}
	
	public String getTestResult(ITestResult itr)
	{
		int resultValue = itr.getStatus();
		switch(resultValue)
		{
			case 1:
				return "PASS";
			case 2:
				return "FAIL";
			case 3:
				return "SKIPPED";
		}
		return "Not Completed";
	}
	
	
	
}
