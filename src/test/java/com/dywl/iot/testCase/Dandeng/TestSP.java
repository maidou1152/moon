package com.dywl.iot.testCase.Dandeng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;
import com.dywl.iot.listener.TestngListener;

import io.qameta.allure.Description;

@Listeners({TestngListener.class})
public class TestSP extends BaseTest {
	
	  @Description("打开谷歌")
	  @Test
	    public void test01() {
	        driver.get("https://www.google.cn/intl/zh-CN/chrome/");
	        Assert.assertEquals(driver.getTitle(), "百度，你就知道");
	    }
	
	  @Description("打开谷歌")
	   @Test
	    public void test02() {
	        driver.get("https://www.google.cn/intl/zh-CN/chrome/");
	        Assert.assertTrue(driver.getTitle().contains("chrome88"), "是否打开chrome官网页面");
	    }	
}