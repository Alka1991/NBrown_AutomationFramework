package com.cname.nbrown.objectSpecificLib;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.cname.core.framework.webcomponent.WebButton;
import com.cname.core.framework.webcomponent.WebText;
import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;
import com.cname.nbrown.pageObject.PLP_JDW;


public class JDW_OSL
{
	public SeWebDriver swd = null;
	public SeWebElement swe = null;
	public WebText wt = null;
	public WebButton wb = null;
	
	public JDW_OSL()
	{
		swd = new SeWebDriver();
		swe = new SeWebElement();
		wt = new WebText();
		wb = new WebButton();
	}
	
	public void menuNavigation(String tabMenuName, String menuId, String titleVal)
	{
		try
		{
			WebElement w1 = swe.findWebElement("xpath", "//a[text()='"+tabMenuName+"' and @id='"+menuId+"']");
			w1.click();
			swd.waitForWebElementToBoVisible("xpath", PLP_JDW.plpProduct_xpath);
			verifyMenuPage(tabMenuName, titleVal);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean verifyMenuPage(String pageName, String titleText)
	{
		boolean flag = false;
		try
		{
			String val = swd.getBrowserTitle();
			if(val.contains(titleText))
			{
				Reporter.log("We are in "+pageName+" page");
				flag = true;
			}
			else
			{
				Reporter.log("We are not in "+pageName+" page");
				flag = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
}
