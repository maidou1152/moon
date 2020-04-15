package com.dywl.iot.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.dywl.iot.base.BaseTest;
import com.dywl.iot.util.ExcelUtil;

public class LoginTest extends BaseTest {
	
	private static Logger logger=Logger.getLogger(Logger.class);
	
	@Test(dataProvider="getDatas")
	public void f1(String name,String password,String expectedTip,String css) {
		maxWindow();
	/*	Properties properties=new Properties();
		try {
			properties.load(LoginTest.class.getResourceAsStream("/url.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url=properties.getProperty("iotLogin");*/
		to("iotLogin");
		type("用户名输入框", name);
		WebElement inputPassword=getElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		type("密码输入框", password);
		WebElement loginButton=getElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
		WaitTime();
		String str="span[style="+"'"+css+"'"+"]";
		logger.info(str);
		String actual=getText(getElement(By.cssSelector(str)));
		logger.info(actual);
		Assert.assertEquals(actual,expectedTip);
	}

	/**
	 * 数据提供者
	 * @return
	 */
	@DataProvider
	public Object[][] getDatas() {
		/*Object[][] datas={
						  {"admin","123","用户名或密码错误","color: rgb(244, 68, 68);"},
						  {"admin","","密码不能为空！","color: rgb(0, 204, 255);"},
						  {"","123456","用户名不能为空！","color: rgb(0, 204, 255);"},
						  {"admin","1234","用户名或密码错误","color: rgb(244, 68, 68);"},
						  {"admin","123456","登录成功","color: rgb(62, 231, 70);"}
				};
		return datas;*/
		Object[][] datas = ExcelUtil.readExcel("/login.xlsx", 0, 2, 6, 1, 4);
		return datas;
	}
	
	public static void main(String[] args) {
		String css="color: rgb(62, 231, 70);";
		String str="span[style="+"'"+css+"'"+"]";
		System.out.println(str);
	}
}