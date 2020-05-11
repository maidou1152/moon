package com.dywl.iot.testCase.Lamp;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("灯杆")
@Feature("添加GPRS单灯")
public class Success_Update_Test extends BaseTest {

	
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		to("iotLogin");
		maxWindow();
		type("用户名输入框", "admin327", "登录页面");
		moveToElement("密码输入框", "登录页面");
		type("密码输入框", "12345678!","登录页面");
		moveToElement("登录按钮", "登录页面");
		click("点击运行","导航页面");
		WaitTime();
		click("点击灯杆","导航页面");
	}
	
	@Story("添加2G单灯")
	@Description("添加GPRS单灯")
	@Test
	public void addGprsLamp() {
		refresh();
		click("选中第一行的数据","灯杆编辑页面");
		click("灯杆编辑按钮","灯杆编辑页面");
		moveToElement("控制器按钮","灯杆编辑页面");
		WaitTime();
		click("单灯模式","灯杆编辑页面");
		moveToElement("GPRS单灯","灯杆编辑页面");
		Random random=new Random();
		int rand=random.nextInt(1000);
		type("SIM卡号", "sim20190827"+rand,"灯杆编辑页面");
		type("单灯编号", "GPRS_"+rand,"灯杆编辑页面");
		WaitTime();
		click("单灯保存按钮","灯杆编辑页面");
	}
}