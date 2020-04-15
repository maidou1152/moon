package com.dywl.iot.testCase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;

public class AutoTest {
	
	@Test
	public void f1() {
		//设置可执行驱动的路径
//		System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "src/test/resources/2.53.1/IEDriverServer.exe");
		//程序唤起浏览器（IE）
		WebDriver driver=new InternetExplorerDriver();
		driver.get("htt://www.baidu.com");
	}
}
