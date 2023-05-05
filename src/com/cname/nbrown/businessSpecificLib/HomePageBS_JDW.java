package com.cname.nbrown.businessSpecificLib;

import com.cname.core.framework.webcomponent.WebButton;
import com.cname.core.framework.webcomponent.WebText;
import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;
import com.cname.nbrown.pageObject.HomePage_JDW;

public class HomePageBS_JDW 
{
	public SeWebDriver swd = null;
	public SeWebElement swe = null;
	public WebText wt = null;
	public WebButton wb = null;
	
	public HomePageBS_JDW()
	{
		swd = new SeWebDriver();
		swe = new SeWebElement();
		wt = new WebText();
		wb = new WebButton();
	}
	
	public void searchProduct(String productNameOrId)
	{
		try
		{
			wt.enterText("id", HomePage_JDW.searchTextBox_id, productNameOrId);
			wb.clickOnButton("id", HomePage_JDW.searchBtn_id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
