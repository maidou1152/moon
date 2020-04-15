package com.dywl.iot.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class LoginTest2 extends BaseTest {
	
	@Test(enabled=false,dataProvider="getDatas")
	public void f1(String name,String password,String expectedTip,String css) {
		driver.manage().window().maximize();
		String url="http://183.129.159.166:10056/login";
		driver.get(url);
		WaitTime();
		driver.findElement(By.id("name")).sendKeys(name);
		WebElement inputPassword=driver.findElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		inputPassword.sendKeys(password);
		WebElement loginButton=driver.findElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
		WaitTime();
		String actual=driver.findElement(By.cssSelector("span[style=+'"+css+"']")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual,expectedTip);
	}
	
	
	@Test
	public void f3() {
		driver.manage().window().maximize();
		String url="http://183.129.159.166:10056/login";
		driver.get(url);
		driver.findElement(By.id("name")).sendKeys("admin");
		WebElement inputPassword=driver.findElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		inputPassword.sendKeys("123");
		WebElement loginButton=driver.findElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
		WaitTime();
		String actual=driver.findElement(By.cssSelector("span[style='color: rgb(244, 68, 68);']")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual,"用户名或密码错误");
	}
	
	@Test
	public void f4() {
		driver.manage().window().maximize();
		String url="http://183.129.159.166:10056/login";
		driver.get(url);
		driver.findElement(By.id("name")).sendKeys("admin");
		WebElement inputPassword=driver.findElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		inputPassword.sendKeys("");
		WebElement loginButton=driver.findElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
		WaitTime();
		String actual=driver.findElement(By.cssSelector("span[style='color: rgb(0, 204, 255);']")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual,"密码不能为空！");
	}
	
	@Test
	public void f5() {
		driver.manage().window().maximize();
		String url="http://183.129.159.166:10056/login";
		driver.get(url);
		driver.findElement(By.id("name")).sendKeys("");
		WebElement inputPassword=driver.findElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		inputPassword.sendKeys("12345");
		WebElement loginButton=driver.findElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
		WaitTime();
		String actual=driver.findElement(By.cssSelector("span[style='color: rgb(0, 204, 255);']")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual,"用户名不能为空！");
	}
	
	@Test
	public void f2() {
		driver.manage().window().maximize();
		String url="http://183.129.159.166:10056/login";
		driver.get(url);
		driver.findElement(By.id("name")).sendKeys("admin");
		WebElement inputPassword=driver.findElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		inputPassword.sendKeys("123456");
		WebElement loginButton=driver.findElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
		WaitTime();
		String actual=driver.findElement(By.cssSelector("span[style='color: rgb(62, 231, 70);")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual, "登录成功");
	}

	@DataProvider
	public Object[][] getDatas() {
		Object[][] datas={{"admin","123","用户名或密码错误","color: rgb(244, 68, 68);"},
				//		  {"admin","","密码不能为空！","color: rgb(0, 204, 255);"},
				//		  {"","123456","用户名不能为空！","color: rgb(0, 204, 255);"},
				//		  {"admin","1234","用户名或密码错误！","color: rgb(244, 68, 68);"},
				//		  {"admin","123456","登录成功","color: rgb(62, 231, 70);"}
						};
		return datas;
	}
}