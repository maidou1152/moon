package com.dywl.iot.listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Attachment;

/**
 * 执行失败自动截图
 * @author asus
 *
 */
public class TestngListener extends TestListenerAdapter {

	private Logger logger=Logger.getLogger(TestngListener.class);
	
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		BaseTest bt=(BaseTest) tr.getInstance();
		WebDriver driver=bt.getDriver();
		logger.info("进入截图方法");
		System.out.println("进入截图方法");
		screenshot(driver);
	}

	@Attachment(value="失败截图如下",type="image/png")
	public byte[] screenshot(WebDriver driver) {
	   byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	   return screenshotAs;
	}	
}