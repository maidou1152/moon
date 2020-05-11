package com.dywl.iot.testCase.RTU;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dywl.iot.page.RtuAddPage;

import io.qameta.allure.Description;

public class Switch_add_Success extends RtuAddPage {
	
	@Description("添加开关")
	@Test
	public void addSwitch()  {
		refresh();
		WaitTime();
		click("选中第一行的数据");
		WaitTime();
		click("修改配电箱按钮");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		WebElement rtuname=getElement("输入配电箱名称");
		rtuname.clear();
		rtuname.sendKeys("U_"+rtuno.format(new Date()));
		WaitTime();
		click("添加开关");
		WaitTime();
		type("开关名称", "k1");
		WaitTime();
		click("开关保存");
		WaitTime();
		moveToElement("保存按钮");	
	}
}