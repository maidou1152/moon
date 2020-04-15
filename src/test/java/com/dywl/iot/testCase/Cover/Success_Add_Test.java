package com.dywl.iot.testCase.Cover;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class Success_Add_Test extends BaseTest {
	
	
	@Test
	public void addCover() {
		to("coverUrl");
		refresh();
		getElement(By.cssSelector("button[class='ant-btn ant-btn-add ant-btn-icon-only']")).click();;
		SimpleDateFormat rtuno = new SimpleDateFormat("MdHmm");
		WebElement cover=getElements(By.xpath("//*[@id='name']")).get(1);			
		cover.sendKeys("C_"+rtuno.format(new Date()));
		getElement(By.id("longitude")).sendKeys("120.20190903");
		getElement(By.id("latitude")).sendKeys("30.2019");
		WebElement saveButton = driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div[2]/div[2]/div/form/div[8]/button"));
		new Actions(driver).moveToElement(saveButton).perform();
		saveButton.click();
	}


	
	public static void main(String[] args) {
		SimpleDateFormat lampNum = new SimpleDateFormat("yyMMddHms");
//		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        System.out.println(lampNum.format(new Date()));// new Date()为获取当前系统时间
	}
	
}
