package com.dywl.iot.testCase.User;

import java.util.Random;

import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;
import com.dywl.iot.page.UserAddPage;

public class Success_Add_Page extends BaseTest {
	
	
	@Test
	public void addUser() {
		to("usrUrl");
		click("用户添加按钮",UserAddPage.class);
		Random random=new Random();
		int num=random.nextInt(200);
		type("输入用户名", "user2019"+num, UserAddPage.class);
		WaitTime();
		type("输入密码", "12345678!", UserAddPage.class);
		WaitTime();
		click("选中责任区",UserAddPage.class);
		WaitTime();
		click("三标1",UserAddPage.class);
		WaitTime();
		click("选中角色",UserAddPage.class);
		WaitTime();
		moveToElement("选择角色",UserAddPage.class);
		WaitTime();
		moveToElement("确定按钮",UserAddPage.class);
	}
}