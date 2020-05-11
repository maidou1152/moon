package com.dywl.iot.testCase.Guard;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("防盗模块")
@Feature("添加防盗反向测试")
public class Failure_Add_Test extends BaseTest {
	
	@Story("添加防盗,不输入主机名称")
	@Description("不输入主机名称")
	@Test
	public void addNoHostName(){
		to("guardUrl");
		click("添加防盗","防盗添加页面");
		SimpleDateFormat guardno = new SimpleDateFormat("MdHm");
		String guardname=guardno.format(new Date());
		//type("主机名称", "fd_"+guardname);
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
		String expectStr="请输入设备名称";
		assertPartialTextPresent("请输入设备名称",expectStr,"防盗添加页面");
	}
	
	@Story("添加防盗,不输入设备编号")
	@Description("不输入设备编号")
	@Test
	public void addNoEquipmentNumber(){
		to("guardUrl");
		click("添加防盗","防盗添加页面");
		SimpleDateFormat guardno = new SimpleDateFormat("MdHm");
		String guardname=guardno.format(new Date());
		type("主机名称", "fd_"+guardname,"防盗添加页面");
		WaitTime();
		//type("设备编号", "fd_"+guardname);
		WaitTime();
		click("配电箱","防盗添加页面");
		WaitTime();
		click("选择第一条配电箱","防盗添加页面");
		WaitTime();
		click("关闭配电箱","防盗添加页面");
		WaitTime();
		moveToElement("保存","防盗添加页面");
		String expectStr="请输入设备编号";
		assertPartialTextPresent("请输入设备编号",expectStr,"防盗添加页面");
	}
}