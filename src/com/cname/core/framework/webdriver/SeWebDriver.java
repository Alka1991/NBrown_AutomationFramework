package com.cname.core.framework.webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cname.core.framework.utility.Constants;
import com.cname.core.framework.utility.Global;

public class SeWebDriver 
{
	public void get()
	{
		Driver.driver.get(Global.browserUrl);
	}
	
	public void implicitlyWait()
	{
		Driver.driver.manage().timeouts().implicitlyWait(Constants.waitTime, TimeUnit.SECONDS);
	}
	
	public void waitForPageLoad()
	{
		Driver.driver.manage().timeouts().pageLoadTimeout(Constants.waitTime, TimeUnit.SECONDS);
	}
	
	public void waitForWebElementToBoVisible(String locator, String locatorValue)
	{
		WebDriverWait wait = new WebDriverWait(Driver.driver, Constants.waitTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.seByMechanism(locator, locatorValue)));
	}
	
	public String getBrowserTitle()
	{
		return Driver.driver.getTitle();
	}
	
	public String getBrowserPageSource()
	{
		return Driver.driver.getPageSource();
	}
	
	public void to(String url)
	{
		Driver.driver.navigate().to(url);
	}
	
	public void back()
	{
		Driver.driver.navigate().back();
	}
	
	public void forward()
	{
		Driver.driver.navigate().forward();
	}
	
	public void maximizeWindow()
	{
		Driver.driver.manage().window().maximize();
	}
	
	public void setOwnWindowSize()
	{
		Dimension d1 = new Dimension(Constants.browserWidth, Constants.browserHight);
		Driver.driver.manage().window().setSize(d1);
	}
	
	// Select Class Wrapper method
	
	public Select select(String locator, String locatorValue)
	{
		WebElement dorpDownWebElm  = Driver.driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		Select sel = new Select(dorpDownWebElm);
		return sel;
	}
	
	public void selectByVisibleText(String locator, String locatorValue, String text)
	{
		Select sel = select(locator, locatorValue);
		sel.selectByVisibleText(text);
	}
	
	public void selectByValue(String locator, String locatorValue, String ddValue)
	{
		Select sel = select(locator, locatorValue);
		sel.selectByValue(ddValue);
	}
	
	public void selectByIndex(String locator, String locatorValue, int index)
	{
		Select sel = select(locator, locatorValue);
		sel.selectByIndex(index);
	}
	
	public void deSelectByVisibleText(String locator, String locatorValue, String ddValue)
	{
		Select sel = select(locator, locatorValue);
		sel.deselectByVisibleText(ddValue);
	}
	
	public void deSelectByValue(String locator, String locatorValue, String ddValue)
	{
		Select sel = select(locator, locatorValue);
		sel.deselectByValue(ddValue);
	}
	
	public void deSelectAllDDValue(String locator, String locatorValue)
	{
		Select sel = select(locator, locatorValue);
		sel.deselectAll();
		Actions act = new Actions(Driver.driver);
		act.
	}
	
	// Action class Wrapper method
	
	public Actions action()
	{
		Actions act = new Actions(Driver.driver);
		return act;
	}
	
	public void doubleClick(String locator, String locatorValue)
	{
		Actions act = action();
		WebElement w1= Driver.driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		act.doubleClick(w1).perform();
	}
	
	public void rightClick(String locator, String locatorValue)
	{
		Actions act = action();
		WebElement w1= Driver.driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		act.contextClick(w1).perform();
	}
	
	public void dragAndDrop(WebElement source, WebElement dest)
	{
		Actions act = action();
		act.dragAndDrop(source, dest).perform();
	}
	
	public void mouseHover(String locator, String locatorValue)
	{
		Actions act = action();
		WebElement w1 = Driver.driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		act.moveToElement(w1).perform();
	}
	
	public void dragAndDrop1(WebElement source, WebElement dest)
	{
		Actions act = action();
		Action act1 = act.clickAndHold(source).moveToElement(dest).release(dest).build();
		act1.perform();
	}
	
	public void setValue(String locator, String locatorValue, String text)
	{
		Actions act = action();
		WebElement w1 = Driver.driver.findElement(FindBy.seByMechanism(locator, locatorValue));
		act.sendKeys(w1, text).perform();
	}
	
	public void keyDown()
	{
		Actions act = action();
		act.sendKeys(Keys.DOWN).perform();
	}
	
	public void keyUp()
	{
		Actions act = action();
		act.sendKeys(Keys.UP).perform();
	}
	
	public void enter()
	{
		Actions act = action();
		act.sendKeys(Keys.ENTER).perform();
	}
	
	// Windows Handling wrapper method:
	
	public void switchWindows(String winId)
	{
		Driver.driver.switchTo().window(winId);
	}
	
	public void closeExtraWindow()
	{
		String mainWinId = Driver.driver.getWindowHandle();
		
		Set<String> allWinIds = Driver.driver.getWindowHandles();
		
		for(String winId : allWinIds)
		{
			if(!(winId.equals(mainWinId)))
			{
				Driver.driver.close();
			}
		}
	}
	
	// Alert Wrapper methods
	
	public Alert switchToAlertWindow()
	{
		Alert alt=null;
		try 
		{
			alt = Driver.driver.switchTo().alert();
		}
		catch (Exception e) 
		{
		}
		return alt;
	}
	
	public void acceptAlert()
	{
		try
		{
			Alert alt = switchToAlertWindow();
			alt.accept();
		}
		catch(Exception e){}
	}
	
	public void closeAlert()
	{
		try
		{
			Alert alt = switchToAlertWindow();
			alt.dismiss();
		}
		catch(Exception e){}
	}
	
	public String captureAlertText()
	{
		String text=null;
		try
		{
			Alert alt = switchToAlertWindow();
			text = alt.getText();
		}
		catch(Exception e){}
		return text;
	}
	
	
}
