package com.dywl.iot.testCase.Lamp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("灯杆模块")
@Feature("添加灯杆正向测试")
public class Success_Add_Test extends BaseTest {

	@Story("正确添加灯杆")
	@Test
	public void addLamp() throws InterruptedException {
		to("lampUrl");
		click("新增灯杆","灯杆添加页面");
		SimpleDateFormat lampNum = new SimpleDateFormat("MdHm");
		String LampName="L_"+lampNum.format(new Date());
		type("输入灯杆编号",LampName,"灯杆添加页面");
		WaitTime();
		click("选择照明场景","灯杆添加页面");
		WaitTime();
		click("选择道路照明","灯杆添加页面");
		WaitTime();
		clear("经度","灯杆添加页面");
		type("经度", "120.0"+lampNum.format(new Date()),"灯杆添加页面");
		clear("纬度","灯杆添加页面");
		type("纬度", "30.0"+lampNum.format(new Date()),"灯杆添加页面");
		moveToElementXY("点击添加标签", -200, -300,"灯杆添加页面");
		WaitTime();
		moveToElement("保存灯杆按钮","灯杆添加页面");
		WaitTime();
		assertPartialTextPresent("灯杆名称", LampName,"灯杆添加页面");
	}
}