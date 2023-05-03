package com.cname.core.framework.webdriver;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class SeWebElement 
{
	public WebElement findWebElement(String locator, String locatorValue)
	{
		WebElement w1=null;
		try
		{
			w1 = Driver.driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return w1;
	}
	
	public List<WebElement> findWebElements(String locator, String locatorValue)
	{
		List<WebElement> lstWebElm=null;
		try 
		{
			lstWebElm = Driver.driver.findElements(FindBy.seByMechanism(locator, locatorValue));
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return lstWebElm;
	}
	
	public void clickOnWebElm(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		w1.click();
	}
	
	public void setValue(String locator, String locatorValue, String value)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		w1.sendKeys(value);
	}
	
	public String captureVisiableText(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		String val = w1.getText();
		return val;
	}
	
	public String getBackendAttValue(String locator, String locatorValue, String attName)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		String val = w1.getAttribute(attName);
		return val;
	}
	
	public String getCSSValue(String locator, String locatorValue, String cssName)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		String val = w1.getCssValue(cssName);
		return val;
	}
	
	public int getXAxis(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		Point p1 = w1.getLocation();
		int xAxis = p1.x;
		return xAxis;
	}
	
	public int getYAxis(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		Point p1 = w1.getLocation();
		int yAxis = p1.y;
		return yAxis;
	}
	
	public boolean isDisplayed(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		boolean b1 = w1.isDisplayed();
		return b1;
	}
	
	public boolean isEnabled(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		boolean b1 = w1.isEnabled();
		return b1;
	}
	
	public boolean isSelected(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		boolean b1 = w1.isSelected();
		return b1;
	}
	
	public String getTagName(String locator, String locatorValue)
	{
		WebElement w1 = findWebElement(locator, locatorValue);
		String value = w1.getTagName();
		return value;
	}
}
