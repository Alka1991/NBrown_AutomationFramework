package com.cname.core.framework.webcomponent;

import org.testng.Reporter;

import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;

public class WebLink 
{
	public SeWebElement swe=null;
	public SeWebDriver sed=null;
	
	public WebLink()
	{
		swe = new SeWebElement();
		sed = new SeWebDriver();
	}
	
	public boolean isLinkExist(String locator, String locatorValue)
	{
		boolean b1 = false;
		try
		{
			b1 = swe.isDisplayed(locator, locatorValue);
		}
		catch(Exception e){}
		return b1;
	}
	
	public void clickOnWebLink(String locator, String locatorValue)
	{
		boolean flag = isLinkExist(locator, locatorValue);
		if(flag)
		{
			swe.clickOnWebElm(locator, locatorValue);
		}
		else
		{
			Reporter.log("Web Element Link is not present in the Web Page");
		}
	}
}
