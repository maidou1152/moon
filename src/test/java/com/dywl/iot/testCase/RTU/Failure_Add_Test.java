package com.dywl.iot.testCase.RTU;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("配电箱模块")
@Feature("反向测试")
public class Failure_Add_Test extends BaseTest {
	
	
	@Story("添加配电箱，不输入GPRS")
	@Step("不输入GPRS")
	@Test
	public void addWithNogprs() {
		to("rtuUrl");
		click("新增配电箱按钮","配电箱新增页面");
		WaitTime();
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		WaitTime();
		type("输入配电箱名称", "R_"+rtuname,"配电箱新增页面");
		WaitTime();
		type("输入RTU编号",rtuno.format(new Date()),"配电箱新增页面");
		WaitTime();
		click("选择照明场景","配电箱新增页面");
		WaitTime();
		click("选择道路照明","配电箱新增页面");
		WaitTime();
		type("输入安装地址","安装地址","配电箱新增页面");
		WaitTime();
		moveToElement("保存按钮","配电箱新增页面");
		WaitTime();
		String expectStr="请输入GPRS";
		assertPartialTextPresent("请输入GPRS",expectStr,"配电箱新增页面");
		click("关闭按钮", "配电箱新增页面");
		WaitTime();
	}
	
	@Story("添加配电箱，不输入RTU编号")
	@Step("不输入RTU编号")
	@Description("不输入RTU编号")
	@Test
	public void addWithNoRtuNum() {
		to("rtuUrl");
		click("新增配电箱按钮","配电箱新增页面");
		WaitTime();
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		type("输入配电箱名称", "R_"+rtuname,"配电箱新增页面");
		WaitTime();
		type("输入GPRS",gprs.format(new Date()),"配电箱新增页面");
		click("选择照明场景","配电箱新增页面");
		click("选择道路照明","配电箱新增页面");
		String expectStr="请输入RTU编号";
		WaitTime();
		moveToElement("保存按钮","配电箱新增页面");
		WaitTime();
		assertPartialTextPresent("请输入RTU编号",expectStr,"配电箱新增页面");
		WaitTime();
		click("关闭按钮", "配电箱新增页面");
	}
	
	@Story("添加配电箱，不选择照明场景")
	@Step("不选择照明场景")
	@Description("不选择照明场景")
	@Test
	public void addWithNoScene() {
		to("rtuUrl");
		click("新增配电箱按钮","配电箱新增页面");
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		type("输入配电箱名称", "R_"+rtuname,"配电箱新增页面");
		type("输入GPRS",gprs.format(new Date()),"配电箱新增页面");
		type("输入RTU编号",rtuno.format(new Date()),"配电箱新增页面");
		type("输入安装地址","安装地址"+gprs.format(new Date()),"配电箱新增页面");
		moveToElement("保存按钮","配电箱新增页面");
		WaitTime();
		String expectStr="请选择照明场景";
		assertPartialTextPresent("请选择照明场景",expectStr,"配电箱新增页面");
		WaitTime();
		click("关闭按钮", "配电箱新增页面");
	}
	
	@AfterClass
	public void afterClass() {
		moveToElement("点击返回","导航页面");
	}
}