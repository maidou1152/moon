package com.dywl.iot.testCase.Lamp;

import java.util.Random;

import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class Update_Lamp_Page extends BaseTest {

	
	@Test
	public void updateLamp() {
		to("lampUrl");
		getElement("选中第一行的数据").click();
		getElement("灯杆编辑按钮").click();
		getElement("控制器按钮").click();
		getElement("单灯模式").click();
		getElement("GPRS单灯").click();
		Random random=new Random();
		int rand=random.nextInt(1000);
		getElement("SIM卡号").sendKeys("sim20190827"+rand);
		getElement("单灯编号").sendKeys("GPRS_"+rand);
		getElement("保存按钮").click();
	}
}