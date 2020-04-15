package com.dywl.iot.testCase.Lamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class Delet_Lamp_Page extends BaseTest {

	@Test
	public void deleLamp() {
		refresh();
		WaitTime();
		WaitTime();
		WaitTime();
		WaitTime();
		getElement("选中第一行的数据").click();
		getElement("删除灯杆按钮").click();;
		getElement("确定删除该灯杆？").click();
		getElement("确定删除").click();
		getElement("输入密码").sendKeys("123456");
		getElement("确定按钮").click();
	}
	@Test(enabled=false)
	public void deleLamp02() {
		Navigation navigation=driver.navigate();
		navigation.refresh();
		WaitTime();
		driver.findElement(By.xpath("//*[@id='lampTable']/div[1]/div/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]/span/label/span/input")).click();
		WaitTime();
		driver.findElement(By.cssSelector("button[class='ant-btn ant-btn-delete ant-btn-icon-only']")).click();;
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
