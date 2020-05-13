package com.dywl.iot.testCase.User;

import java.util.Random;

import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class Success_Add_Test extends BaseTest {
	
	
	
	@Test
	public void addUser() {
		to("usrUrl");
		click("用户添加按钮","用户添加页面");
		Random random=new Random();
		int num=random.nextInt(200);
		type("输入用户名", "user2019"+num, "用户添加页面");
		WaitTime();
		type("输入密码", "12345678!", "用户添加页面");
		WaitTime();
		click("选中责任区","用户添加页面");
		WaitTime();
		click("三标1","用户添加页面");
		WaitTime();
		click("选中角色","用户添加页面");
		WaitTime();
		moveToElement("选择角色","用户添加页面");
		WaitTime();
		moveToElement("确定按钮","用户添加页面");
	}
}