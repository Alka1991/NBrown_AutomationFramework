package com.cname.nbrown.TestInitialization;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.cname.core.framework.datalayer.ExcelDriver;
import com.cname.core.framework.webcomponent.WebButton;
import com.cname.core.framework.webcomponent.WebLink;
import com.cname.core.framework.webcomponent.WebText;
import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;
import com.cname.nbrown.businessSpecificLib.HomePageBS_JDW;
import com.cname.nbrown.businessSpecificLib.LoginPageBS_JDW;
import com.cname.nbrown.objectSpecificLib.JDW_OSL;

public class TestInitializationScript 
{
	public SeWebDriver seWDriver = new SeWebDriver();
	public SeWebElement seWElm = new SeWebElement();
	public ExcelDriver excel = new ExcelDriver();
	public WebButton wb = new WebButton();
	public WebText wt = new WebText();
	public WebLink wl = new WebLink();
	public LoginPageBS_JDW lp = new LoginPageBS_JDW(); 
	public HomePageBS_JDW hp = new HomePageBS_JDW();
	public JDW_OSL jdwOSL = new JDW_OSL();
	
	
	
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
