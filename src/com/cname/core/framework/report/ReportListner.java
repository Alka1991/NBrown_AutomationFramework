package com.cname.core.framework.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportListner implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log(result.getMethod().getMethodName()+" Test is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log(result.getMethod().getMethodName()+" Test is PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		Reporter.log(result.getMethod().getMethodName()+" Test is FAILED");
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log(result.getMethod().getMethodName()+" Test is SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		Reporter.log(result.getMethod().getMethodName()+" Test is FAILED with some success percentage");
	}

	@Override
	public void onStart(ITestContext context)
	{
		Reporter.log(context.getName()+" Test is getting start ");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		Reporter.log(context.getName()+" Test is getting Finish ");
	}

}
