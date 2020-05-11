package com.dywl.iot.testCase.RTU;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;
import com.dywl.iot.page.NavigationPage;
import com.dywl.iot.page.RtuUpdatePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("配电箱")
@Feature("RTU修改正向测试")
public class Rtu_Update_Success extends BaseTest {
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		click("点击运行",NavigationPage.class);
		WaitTime();
		click("点击配电箱",NavigationPage.class);
	}
	
	@Description("修改配电箱名称")
	@Test
	public void updateRtu()  {
		refresh();
		WaitTime();
		click("选中第一行的数据",RtuUpdatePage.class);
		WaitTime();
		click("修改配电箱按钮",RtuUpdatePage.class);
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		clear("输入配电箱名称",RtuUpdatePage.class);
		type("输入配电箱名称","U_"+rtuno.format(new Date()), RtuUpdatePage.class);
		WaitTime();
		moveToElement("保存按钮",RtuUpdatePage.class);	
	}
	
	@Description("添加开关")
	@Test
	public void addSwitch()  {
		refresh();
		WaitTime();
		click("选中第一行的数据",RtuUpdatePage.class);
		WaitTime();
		click("修改配电箱按钮",RtuUpdatePage.class);
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		clear("输入配电箱名称",RtuUpdatePage.class);
		WaitTime();
		type("输入配电箱名称","U_"+rtuno.format(new Date()), RtuUpdatePage.class);
		WaitTime();
		click("添加开关",RtuUpdatePage.class);
		WaitTime();
		type("开关名称", "k1",RtuUpdatePage.class);
		WaitTime();
		click("开关保存",RtuUpdatePage.class);
		WaitTime();
		moveToElement("保存按钮",RtuUpdatePage.class);	
	}
	
	@Description("高级配置-RTU标定")
	@Test
	public void RTUCalibration()  {
		refresh();
		click("选中第一行的数据",RtuUpdatePage.class);
		click("高级配置按钮",RtuUpdatePage.class);
		moveToElement("高级配置保存按钮",RtuUpdatePage.class);
		WaitTime();
		click("确定",RtuUpdatePage.class);
		//RTU标定修改成功
		String expectStr="RTU标定修改成功";
		assertPartialTextPresent("RTU标定修改成功",expectStr,RtuUpdatePage.class);
	}
	
	@Description("高级配置-快速标定")
	@Test
	public void RTUFastCalibration()  {
		refresh();
		click("选中第一行的数据",RtuUpdatePage.class);
		WaitTime();
		click("高级配置按钮",RtuUpdatePage.class);
		WaitTime();
		click("快速标定标签",RtuUpdatePage.class);
		moveToElement("保存按钮",RtuUpdatePage.class);
		WaitTime();
		click("确定",RtuUpdatePage.class);
		String expectStr="RTU标定修改成功";
		assertPartialTextPresent("RTU标定修改成功",expectStr,RtuUpdatePage.class);
	}
	@Description("高级配置-RTU高级配置")
	@Test
	public void RTUHiCalibration()  {
		refresh();
		click("选中第一行的数据",RtuUpdatePage.class);
		WaitTime();
		click("高级配置按钮",RtuUpdatePage.class);
		WaitTime();
		click("RTU高级配置标签",RtuUpdatePage.class);
		moveToElement("招测按钮",RtuUpdatePage.class);
		WaitTime();
		click("确定",RtuUpdatePage.class);
		WaitTime();
		String expectStr="招测命令已下发";
		assertPartialTextPresent("招测命令已下发",expectStr,RtuUpdatePage.class);
	}
}