package com.dywl.iot.testCase.Lamp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;

public class Add_Lamp_Page extends BaseTest {

	@TmsLink("1002")
	@Feature("增加灯杆")
	@Test
	public void addLamp() throws InterruptedException {
		to("lampUrl");
		click("新增灯杆");
		SimpleDateFormat lampNum = new SimpleDateFormat("MdHm");
		String LampName="L_"+lampNum.format(new Date());
		type("输入灯杆编号",LampName);
		Thread.sleep(5000);
		//driver.findElement(By.cssSelector("div[class='ant-select-selection__rendered']")).click();
		//driver.findElement(By.xpath("/html/body/div[5]/div/div/div/ul/li[1]")).click();
		click("选择照明场景");
		click("选择道路照明");
		WebElement longitudeText=getElement("经度");
		longitudeText.clear();
		//longitudeText.sendKeys("120.13011");
		type("经度", "120.13011");
		WebElement lampWindow=getElement("点击添加标签");
		new Actions(driver).moveToElement(lampWindow, -200, -300).perform();
		WaitTime();
		moveToElement("保存灯杆按钮");
		WaitTime();
		assertPartialTextPresent("灯杆名称", LampName);
	}
}