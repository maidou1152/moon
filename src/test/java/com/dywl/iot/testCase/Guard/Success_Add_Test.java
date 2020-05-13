package com.dywl.iot.testCase.Guard;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("防盗模块")
@Feature("添加防盗正向测试")
public class Success_Add_Test extends BaseTest {
	
	@BeforeClass
	public void beforClass() {
		click("点击运行", "导航页面");
		WaitTime();
		click("点击防盗", "导航页面");
	}
	
	@Story("添加防盗II,输入正确的数据")
	@Description("正确添加防盗II")
	@Test
	public void addGuardTwo(){
		//to("guardUrl");
		click("添加防盗","防盗添加页面");
		SimpleDateFormat guardno = new SimpleDateFormat("MdHmm");
		String guardname=guardno.format(new Date());
		type("主机名称", "fd_"+guardname,"防盗添加页面");
		WaitTime();
		type("设备编号", "fd_"+guardname,"防盗添加页面");
		WaitTime();
		click("配电箱","防盗添加页面");
		WaitTime();
		click("选择第一条配电箱","防盗添加页面");
		WaitTime();
		click("关闭配电箱","防盗添加页面");
		WaitTime();
		moveToElement("保存","防盗添加页面");
	}
	
	@Story("添加防盗III,输入正确的数据")
	@Description("正确添加防盗III")
	@Test
	public void addGuardThree(){
	//	to("guardUrl");
		click("添加防盗","防盗添加页面");
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat guardno = new SimpleDateFormat("MdHmm");
		String guardname=guardno.format(new Date());
		String guardphone=gprs.format(new Date());
		type("主机名称", "fd_"+guardname,"防盗添加页面");
		WaitTime();
		type("设备编号", "fd_"+guardname,"防盗添加页面");
		WaitTime();
		type("通讯号",guardphone,"防盗添加页面");
		WaitTime();
		//防盗类型
		click("防盗2","防盗添加页面");
		WaitTime();
		moveToElement("防盗3","防盗添加页面");
		WaitTime();
		click("配电箱","防盗添加页面");
		WaitTime();
		click("选择第一条配电箱","防盗添加页面");
		WaitTime();
		click("关闭配电箱","防盗添加页面");
		WaitTime();
		moveToElement("保存","防盗添加页面");
	}
	
	@AfterClass
	public void afterClass() {
		moveToElement("点击返回", "导航页面");
	}
}