package com.dywl.iot.testCase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IETest {
	
	@Test
	public void f1() {
		//设置可执行驱动的路径
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, "src/test/resources/2.53.1/IEDriverServer.exe");
		//驱动期望的能力
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//忽略IE安全设置
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//忽略页面缩放
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		//设置初始url
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"http://www.baidu.com");
		//通过能力创建浏览器（IE）
		WebDriver driver=new InternetExplorerDriver(capabilities);
		driver.quit();
	}
}