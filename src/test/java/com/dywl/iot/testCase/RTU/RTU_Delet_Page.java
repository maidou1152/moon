package com.dywl.iot.testCase.RTU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class RTU_Delet_Page extends BaseTest {

	@Test
	public void deleRtu() {
		to("rtuUrl");
		//refresh();
		getElement("选中第三行的数据").click();
		getElement("删除按钮").click();
		getElement("确定删除此配电箱？").click();
		getElement("点击确定按钮").click();
		getElement("输入密码").sendKeys("123456");
		getElement("确定删除");
	}
	@Test(enabled=false)
	public void deleRtu02() {
		Navigation navigation=driver.navigate();
		navigation.refresh();
		WaitTime();
		driver.findElement(By.xpath("//*[@id='rtuTable']/div[1]/div/div/div/div/div/div[2]/table/tbody/tr[4]/td[1]/span/label/span/input")).click();
		WaitTime();
		driver.findElement(By.cssSelector("button[class='ant-btn ant-btn-delete ant-btn-icon-only']")).click();
		WaitTime();
		driver.findElement(By.cssSelector("div[class='ant-modal-body']")).click();
		WaitTime();
		WebElement saveButton = driver.findElement(By.cssSelector("button[class='ant-btn ant-btn-primary ant-btn-lg'"));
		saveButton.click();
		WaitTime();
		driver.findElement(By.cssSelector("input[placeholder='请输入密码']")).sendKeys("123456");
		WaitTime();
		driver.findElement(By.cssSelector("button[class='ant-btn ant-btn-primary ant-btn-lg'")).click();
	}
}
