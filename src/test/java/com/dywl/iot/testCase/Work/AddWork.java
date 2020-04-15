package com.dywl.iot.testCase.Work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTestWorkItem;

public class AddWork extends BaseTestWorkItem {

	
	@Test
	public void add_work() throws InterruptedException {
		driver.findElement(By.partialLinkText("派工管理")).click();
		Thread.sleep(3000);
		WebElement iframe=driver.findElement(By.cssSelector("iframe[src='/home/console']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'添 加')]")).click();
		Thread.sleep(3000);
		//添加工单ifram
		WebElement iframeorder=driver.findElement(By.cssSelector("iframe[src='/order/add']"));
		driver.switchTo().frame(iframeorder);
		driver.findElement(By.id("type")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(text(),'路灯')]")).click();
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//li[contains(text(),'监控故障')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder='请选择工单来源']")).click();
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//dd[contains(text(),'数字城管')]")).click();
		Thread.sleep(3000);		
		driver.findElement(By.name("callerName")).sendKeys("cc");
		Thread.sleep(3000);		
		driver.findElement(By.name("content")).sendKeys("我是一条工单");
		Thread.sleep(3000);		
		//提交按钮
		driver.findElement(By.id("1")).click();
		
	}
}
