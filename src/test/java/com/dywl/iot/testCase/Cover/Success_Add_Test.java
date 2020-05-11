package com.dywl.iot.testCase.Cover;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;
import com.dywl.iot.page.CoverAddPage;

public class Success_Add_Test extends BaseTest {
	
	
	@Test
	public void addCover() {
		to("coverUrl");
		WaitTime();
		click("添加井盖",CoverAddPage.class);
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		type("井盖名称", "C_"+rtuno.format(new Date()), CoverAddPage.class);
		type("经度", "120.20190903",CoverAddPage.class);
		type("纬度", "30.2019",CoverAddPage.class);
		WaitTime();
		moveToElement("保存按钮",CoverAddPage.class);
	}
}