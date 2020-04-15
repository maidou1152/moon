package com.dywl.iot.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dywl.iot.util.SeleniumUtil;

public class FindElementTest {

	@Test 
	//把testng.xml中间的参数给注入进入
	@Parameters(value={"browserType","seleniumVersion","driverPath"})
	public void case01(String browserType,String seleniumVersion,String driverPath) {
		WebDriver driver= SeleniumUtil.openBrowser(browserType, seleniumVersion, driverPath);
		driver.get("http://wwww.baidu.com");
		//id
		WebElement input=driver.findElement(By.id("kw"));
		String actual=input.getAttribute("autocomplete");
		Assert.assertEquals(actual, "off");
		//name
		WebElement inputEleme=driver.findElement(By.name("wd"));
		String actul01=inputEleme.getAttribute("autocomplete");
		Assert.assertEquals(actul01, "off");
		//tagname
		
		//className
		WebElement inputEleme2=driver.findElement(By.className("s_ipt"));
		String actul02=inputEleme.getAttribute("autocomplete");
		Assert.assertEquals(actul01, "off");
		//cssSelector
		driver.findElement(By.cssSelector("input.s_ipt")).sendKeys("java");
		//退出浏览器
		//driver.quit();
	}
}
