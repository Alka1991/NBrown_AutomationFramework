package com.testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cname.core.framework.webdriver.Driver;
import com.cname.core.framework.webdriver.FindBy;
import com.cname.nbrown.TestInitialization.TestInitializationScript;

public class Test2 extends TestInitializationScript
{
	@Test
	public void test1() throws Exception
	{
		WebDriver driver = Driver.getBrowserInstance();
		seWDriver.maximizeWindow();
		seWDriver.get();
		Thread.sleep(3000);
		
		WebElement w1 = driver.findElement(FindBy.seByMechanism("xpath", "//a[contains(text(),'Create new account')]"));
		w1.click();
		Thread.sleep(3000);
		
		seWDriver.selectByVisibleText("id", "month", "Nov");
		
	}
}
