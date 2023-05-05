package com.cname.nbrown.businessSpecificLib;

import com.cname.core.framework.webcomponent.WebButton;
import com.cname.core.framework.webcomponent.WebText;
import com.cname.core.framework.webdriver.SeWebDriver;
import com.cname.core.framework.webdriver.SeWebElement;
import com.cname.nbrown.pageObject.LogInPage_JDW;

public class LoginPageBS_JDW 
{
	public SeWebDriver swd = null;
	public SeWebElement swe = null;
	public WebText wt = null;
	public WebButton wb = null;
	
	public LoginPageBS_JDW()
	{
		swd = new SeWebDriver();
		swe = new SeWebElement();
		wt = new WebText();
		wb = new WebButton();
	}
	
	public void loginToApp_JDW(String usename, String password)
	{
		try
		{
			wt.enterText("xpath", LogInPage_JDW.unText_xpath, usename);
			wt.enterText("id", LogInPage_JDW.pwText_id, password);
			wb.clickOnButton("xpath", LogInPage_JDW.signInBtn_xpath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
