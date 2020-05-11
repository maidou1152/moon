package com.dywl.iot.testCase.RTU;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;


@Epic("配电箱")
@Feature("RTU修改")
public class RTU_Update_Page extends BaseTest {
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		click("点击运行");
		WaitTime();
		click("点击配电箱");
	}
	
	@Description("修改配电箱名称")
	@Test
	public void updateRtu()  {
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
		moveToElement("保存按钮");	
	}
	
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

	@Description("添加开关k2")
	@Test
	public void addSwitchk2()  {
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
		type("开关名称", "k2");
		WaitTime();
		click("开关保存");
		WaitTime();
		moveToElement("保存按钮");	
	}
	
	@Description("高级配置-RTU标定")
	@Test(enabled=false)
	public void RTUCalibration()  {
		//to("rtuUrl");
		refresh();
		click("选中第一行的数据");
		click("高级配置按钮");
		moveToElement("高级配置保存按钮");
		WaitTime();
		click("确定");
		//RTU标定修改成功
		String expectStr="RTU标定修改成功";
		assertPartialTextPresent("RTU标定修改成功",expectStr);
	}
	
	@Description("高级配置-快速标定")
	@Test(enabled=false)
	public void RTUFastCalibration()  {
		refresh();
		click("选中第一行的数据");
		WaitTime();
		click("高级配置按钮");
		WaitTime();
		click("快速标定标签");
		moveToElement("保存按钮");
		WaitTime();
		click("确定");
		String expectStr="RTU标定修改成功";
		assertPartialTextPresent("RTU标定修改成功",expectStr);
	}
	@Description("高级配置-RTU高级配置")
	@Test(enabled=false)
	public void RTUHiCalibration()  {
		refresh();
		click("选中第一行的数据");
		WaitTime();
		click("高级配置按钮");
		WaitTime();
		click("RTU高级配置标签");
		moveToElement("招测按钮");
		WaitTime();
		click("确定");
		WaitTime();
		String expectStr="招测命令已下发";
		assertPartialTextPresent("招测命令已下发",expectStr);
	}
}