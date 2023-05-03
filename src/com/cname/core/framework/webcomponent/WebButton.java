package com.cname.core.framework.webcomponent;

import org.testng.Reporter;

import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;

public class WebButton
{
	public SeWebElement swe=null;
	public SeWebDriver sed=null;
	
	public WebButton()
	{
		swe = new SeWebElement();
		sed = new SeWebDriver();
	}
	public boolean isButtonExist(String locator, String locatorValue)
	{
		boolean b=false;
		try
		{
			
			b = swe.isDisplayed(locator, locatorValue);
			
		}
		catch(Exception e){}
		return b;
	}
	
	public void clickOnButton(String locator, String locatorValue)
	{
		boolean b1 = isButtonExist(locator, locatorValue);
		if(b1)
		{
			swe.clickOnWebElm(locator, locatorValue);
		}
		else
		{
			Reporter.log("Buuton is not present in the page");
		}
	}
	
	public void doubleClickOnButton(String locator, String locatorValue)
	{
		boolean b1 = isButtonExist(locator, locatorValue);
		if(b1)
		{
			sed.doubleClick(locator, locatorValue);
		}
		else
		{
			Reporter.log("Buuton is not present in the page");
		}
	}
}
