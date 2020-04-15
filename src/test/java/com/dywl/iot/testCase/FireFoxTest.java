package com.dywl.iot.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.testng.annotations.Test;

public class FireFoxTest {
	
	@Test
	public void f1() {
		//1:设置火狐可执行文件的路径
		System.setProperty(SystemProperty.BROWSER_BINARY, "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//2.X：不需要可执行的驱动文件:推荐：selenium2.53.1+火狐46.0 geckdriver 0.16.0
		//3.X：需要可执行的驱动：jdk1.8
		System.setProperty("webdriver.gecko.driver", "src/test/resources/2.53.1/geckodriver.exe");
		WebDriver fireFox=new FirefoxDriver();
		fireFox.get("http://www.baidu.com");
	}
}
