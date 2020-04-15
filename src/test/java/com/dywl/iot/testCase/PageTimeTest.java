package com.dywl.iot.testCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class PageTimeTest extends BaseTest{
	
	@Test
	public void f() {
		try {
			driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);	
			driver.get("http://www.baidu.com");
		} catch (Exception e) {
			JavascriptExecutor executor=(JavascriptExecutor) driver;
			executor.executeScript("window.stop");
		}
		
	}
	
	@Test
	public void f1() {
		Window window=driver.manage().window();
		window.getPosition().getX();
		window.getPosition().getY();
		Dimension dim=window.getSize();
		dim.getHeight();
		dim.getWidth();
	}
	
}
