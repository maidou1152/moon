package com.dywl.iot.testCase.RTU;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

@Epic("配电箱")
@Feature("RTU新增")
public class RTU_Add_Page extends BaseTest {
	
	@Description("正确添加RTU")
	@Test
	public void addRtu() {
		to("rtuUrl");
		getElement("新增配电箱按钮").click();
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		type("输入配电箱名称", "R_"+rtuname);
		type("输入GPRS",gprs.format(new Date()));
		type("输入RTU编号",rtuno.format(new Date()));
		click("选择照明场景");
		click("选择道路照明");
		type("输入安装地址","安装地址"+gprs.format(new Date()));
		/*WebElement saveButton = getElement("保存按钮");
		new Actions(driver).moveToElement(saveButton).perform();
		saveButton.click();*/
		moveToElement("保存按钮");
		WaitTime();
		String expectStr="配电箱创建成功";
		assertPartialTextPresent("创建成功",expectStr);
	}
	
	@Description("不输入GPRS")
	@Test
	public void addWithNogprs() {
		to("rtuUrl");
		getElement("新增配电箱按钮").click();
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		type("输入配电箱名称", "R_"+rtuname);
		type("输入RTU编号",rtuno.format(new Date()));
		click("选择照明场景");
		click("选择道路照明");
		type("输入安装地址","安装地址");
		moveToElement("保存按钮");
		WaitTime();
		String expectStr="请输入GPRS";
		assertPartialTextPresent("请输入GPRS",expectStr);
	}
	@Description("不输入RTU编号")
	@Test
	public void addWithNoRtuNum() {
		to("rtuUrl");
		getElement("新增配电箱按钮").click();
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		type("输入配电箱名称", "R_"+rtuname);
		WaitTime();
		type("输入GPRS",gprs.format(new Date()));
		click("选择照明场景");
		click("选择道路照明");
		String expectStr="请输入RTU编号";
		WaitTime();
		moveToElement("保存按钮");
		WaitTime();
		assertPartialTextPresent("请输入RTU编号",expectStr);
	}
	
	@Description("不选择照明场景")
	@Test
	public void addWithNoScene() {
		to("rtuUrl");
		getElement("新增配电箱按钮").click();
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		String rtuname=rtuno.format(new Date());
		type("输入配电箱名称", "R_"+rtuname);
		type("输入GPRS",gprs.format(new Date()));
		type("输入RTU编号",rtuno.format(new Date()));
		type("输入安装地址","安装地址"+gprs.format(new Date()));
		moveToElement("保存按钮");
		WaitTime();
		String expectStr="请选择照明场景";
		assertPartialTextPresent("请选择照明场景",expectStr);
	}

	@Test(enabled=false)
	public void addRtuback() {
		to("rtuUrl");
		WaitTime();
		getElement(By.cssSelector("button[class='ant-btn ant-btn-add ant-btn-icon-only']")).click();;
		SimpleDateFormat gprs = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		WaitTime();
		driver.findElement(By.cssSelector("input[placeholder='这里输入名称']")).sendKeys("R_"+rtuno.format(new Date()));
		driver.findElement(By.id("serialNumber")).sendKeys(gprs.format(new Date()));
		driver.findElement(By.id("channelNumber")).sendKeys(rtuno.format(new Date()));
		driver.findElement(By.xpath("//div[contains(text(),'请选择照明场景')]")).click();
		WaitTime();
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/ul/li[1]")).click();
		WebElement saveButton = driver.findElement(By.cssSelector("button[type='submit']"));
		new Actions(driver).moveToElement(saveButton).perform();
		saveButton.click();
	}

	
	public static void main(String[] args) {
		SimpleDateFormat lampNum = new SimpleDateFormat("yyMMddHms");
//		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        System.out.println(lampNum.format(new Date()));// new Date()为获取当前系统时间
	}  
}