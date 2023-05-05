package com.cname.core.framework.webcomponent;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;

public class WebText 
{
	public SeWebElement swe=null;
	public SeWebDriver sed=null;
	
	public WebText()
	{
		swe = new SeWebElement();
		sed = new SeWebDriver();
	}
	
	public boolean isTextBoxExist(String locator, String locatorValue)
	{
		boolean b1 = false;
		try
		{
			b1 = swe.isDisplayed(locator, locatorValue);
		}
		catch(Exception e){}
		return b1;
	}
	
	public void enterText(String locator, String locatorValue, String text)
	{
		boolean flag = isTextBoxExist(locator, locatorValue);
		if(flag)
		{
			swe.setValue(locator, locatorValue, text);
		}
		else
		{
			Reporter.log("Web Element Text is not present in the Web Page");
		}
	}
}
