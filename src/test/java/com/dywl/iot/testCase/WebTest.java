package com.dywl.iot.testCase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dywl.iot.util.SeleniumUtil;

public class WebTest {
	
	@Test 
	//把testng.xml中间的参数给注入进入
	@Parameters(value={"browserType","seleniumVersion","driverPath"})
	public void case01(String browserType,String seleniumVersion,String driverPath) {
		SeleniumUtil.openBrowser(browserType, seleniumVersion, driverPath);
	}
}
