package com.dywl.iot.testCase.workItem;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class Add_WorkItem_Page extends BaseTest {

	@Test
	public void addItme() {
		to("gongdanUrl");
		getElement("新增工单").click();
		getElement("请先选择工单类型").click();
		List<WebElement> s=getElements("设备类型");
		for (WebElement webElement : s) {
			System.out.println(webElement.getText());
		}
		getElements("设备类型").get(0).click();
		getElement("来电人姓名").sendKeys("w");
		getElement("输入工单内容").sendKeys("我是一条小小的工单");
		new Actions(driver).moveToElement(getElement("添加工单"),-200, -300).perform();
		new Actions(driver).moveToElement(getElement("提交按钮")).perform();
		getElement("提交按钮").click();
	}
}