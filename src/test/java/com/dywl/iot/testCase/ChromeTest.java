package com.dywl.iot.testCase;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ChromeTest {

	@Test
	public void f1() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://ww.baidu.com");
	}
}
