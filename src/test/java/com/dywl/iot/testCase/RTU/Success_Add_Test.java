package com.dywl.iot.testCase.RTU;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dywl.iot.page.RtuAddPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("配电箱模块")
@Feature("正向测试")
public class Success_Add_Test extends RtuAddPage {
	
	@BeforeClass
	public void beforClass() {
		click("点击运行","导航页面");
		WaitTime();
		click("点击配电箱","导航页面");
		WaitTime();
	}
	
	@Story("添加配电箱，正确添加参数")
	@Description("正确添加RTU")
	@Step("验证正常添加RTU功能")
	@Test
	public void addRtu() {
		//to("rtuUrl");
		click("新增配电箱按钮","配电箱新增页面");
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		type("输入配电箱名称", "R_"+rtuname,"配电箱新增页面");
		type("输入GPRS",gprs.format(new Date()),"配电箱新增页面");
		type("输入RTU编号",rtuno.format(new Date()),"配电箱新增页面");
		click("选择照明场景","配电箱新增页面");
		click("选择道路照明","配电箱新增页面");
		type("输入安装地址","安装地址"+gprs.format(new Date()),"配电箱新增页面");
		moveToElement("保存按钮","配电箱新增页面");
		WaitTime();
		//配电箱创建成功
		String expectStr="配电箱创建成功";
		assertPartialTextPresent("创建成功",expectStr,"配电箱新增页面");
		WaitTime();
	}
	
	@AfterClass
	public void afterClass() {
		moveToElement("点击返回","导航页面");
	}
	
}