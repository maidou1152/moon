package com.dywl.iot.testCase.RTU;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;
import com.dywl.iot.page.RtuUpdatePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("配电箱")
@Feature("RTU修改反向测试")
public class Rtu_Update_Failure extends BaseTest {
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		click("点击运行",RtuUpdatePage.class);
		WaitTime();
		click("点击配电箱",RtuUpdatePage.class);
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
		type("输入配电箱名称","UF_"+rtuno.format(new Date()), RtuUpdatePage.class);
		WaitTime();
		moveToElement("保存按钮",RtuUpdatePage.class);	
	}
}