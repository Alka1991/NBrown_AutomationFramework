package com.cname.nbrown.TestScenarios.JDW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cname.core.framework.report.ReportListner;
import com.cname.core.framework.webdriver.Driver;
import com.cname.core.framework.webdriver.FindBy;
import com.cname.nbrown.TestInitialization.TestInitializationScript;
import com.cname.nbrown.pageObject.PDP_JDW;
import com.cname.nbrown.pageObject.PLP_JDW;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})
public class searchProduct_101_JDW_AMER extends TestInitializationScript
{
	{
		System.setProperty("atu.reporter.config", "D:\\Automation_batch\\Java_program\\Phase1_MileStone2_JDW\\NBrownReport\\atu.properties");
	}
	
	@Test
	public void searchProductTest()
	{
		try 
		{
			WebDriver driver = Driver.getBrowserInstance();
			ATUReports.setWebDriver(driver);
			setAuthorInfoForReports();
			seWDriver.maximizeWindow();
			seWDriver.get();
			seWDriver.implicitlyWait();
			Thread.sleep(3000);
			
			try
			{
				WebElement w1 = driver.findElement(FindBy.seByMechanism("xpath", "//button[text()='Accept All Cookies']"));
				w1.click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			//jdwOSL.menuNavigation("Electricals", "topNav_Electricals", "Electricals");

			hp.searchProduct("Jeans");
			seWDriver.waitForWebElementToBoVisible("xpath", PLP_JDW.plpProduct_xpath);
			String expectedTitle = "jeans | JD Williams";
			String actualTitle = seWDriver.getBrowserTitle();
			ATUReports.add("Verify PLP Page", expectedTitle, actualTitle, true);
			
			seWElm.clickOnWebElm("xpath", PLP_JDW.plpProduct_xpath);
			seWDriver.waitForWebElementToBoVisible("xpath", PDP_JDW.review_xpath);
			ATUReports.add("Verify PDP Page", "Jeans", "Jeans", true);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void setAuthorInfoForReports() {
        ATUReports.setAuthorInfo("Pritam Kumar", Utils.getCurrentTime(),
                     "1.0");
 }
}
