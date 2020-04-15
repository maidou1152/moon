package com.dywl.iot.testCase.User;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class Add_User_Page extends BaseTest {
	
	
	@Test
	public void addUser() {
		to("usrUrl");
		getElement("用户添加按钮").click();
		Random random=new Random();
		int num=random.nextInt(200);
		getElement("输入用户名").sendKeys("user2019"+num);
		getElement("输入密码").sendKeys("123456");
		getElement("选中责任区").click();
		getElement("三标1").click();
		getElement("选中角色").click();
		getElement("选择角色").click();
		WebElement saveButton = getElement("确定按钮");
		new Actions(driver).moveToElement(saveButton).perform();
		saveButton.click();
	}
	
	@Test
	public void addUser001() {
		to("usrUrl");
	//	getElement(By.partialLinkText("用户管理")).click();
		getElement(By.cssSelector("span[class='opAdd___135J1']")).click();
		Random random=new Random();
		int num=random.nextInt(200);
		getElement(By.xpath("//*[@id='name']")).sendKeys("user2019"+num);
		WaitTime();
		getElement(By.id("password")).sendKeys("123456");
		WaitTime();
		getElement(By.cssSelector("/html/body/div[5]/div/div[2]/div/div[1]/div[2]/form/div[7]/div[2]/div")).click();
		
		getElement(By.cssSelector("span[title='三标1']")).click();
		WebElement saveButton = getElement(By.cssSelector("button[class='ant-btn ant-btn-primary ant-btn-lg']"));
		new Actions(driver).moveToElement(saveButton).perform();
		saveButton.click();
	}
	
	public static void main(String[] args) {
		Random random=new Random();
		int num=random.nextInt(2000);
		System.err.println("user_"+num);
	}
}
