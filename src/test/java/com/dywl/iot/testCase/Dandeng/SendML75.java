package com.dywl.iot.testCase.Dandeng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;
import com.dywl.iot.util.Excel;


/**
 * 批量开关命令：75
 * @author asus
 *
 */
public class SendML75 extends BaseTest {

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("运行")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("灯杆")).click();
	}
	
	@Test(dataProvider = "getDatas" )
	public void sendSevenFive(String rtuno) throws InterruptedException {
		//to("lampUrl");
		//点击配电箱
		driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div/div[2]/div/div[2]/div[3]/button")).click();
		Thread.sleep(3000);
		//点击输入框 输入内容
		driver.findElement(By.cssSelector("input[placeholder='请输入名称/Rtu编号/安装地址/GPRS通讯号']")).sendKeys(rtuno);;
		Thread.sleep(3000);
		//点击查询
		driver.findElement(By.cssSelector("i[class='anticon anticon-search ant-input-search-icon']")).click();
		Thread.sleep(3000);
		//点击radio  
		driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div[2]/div[2]/div/div[1]/div/div/div/div/div/div[2]/table/tbody/tr/td[1]/span/label/span/input")).click();
		Thread.sleep(2000);
		//点击确认
		driver.findElement(By.cssSelector("button[class='ant-btn rtuListConfirm']")).click();
		Thread.sleep(2000);
		//点击20页
		//driver.findElement(By.cssSelector("div[title='20条/页']")).click();
		driver.findElement(By.xpath("//*[@id='lampTable']/div[2]/div/div/div/div")).click();
		Thread.sleep(2000);
		//选择500页
		driver.findElement(By.xpath("//div[@class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-topLeft']/div/ul/li[5]")).click();
		Thread.sleep(3000);
		//列表全选
		driver.findElement(By.xpath("//*[@id='lampTable']/div[1]/div/div/div/div/div/div[1]/table/thead/tr/th[1]/span/div/label/span/input")).click();
		Thread.sleep(3000);
		//控制
		driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div/div[2]/div/div[1]/div[4]/div/div")).click();
		Thread.sleep(3000);
		//批量开关命令
		WebElement bt=driver.findElement(By.xpath("//div[@class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft']/div/ul/li[6]"));
		Actions action=new Actions(driver);
		action.moveToElement(bt).perform();
		action.click(bt).perform();
		Thread.sleep(2000);
		//移动到调光
		WebElement tiaoguang=driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div[3]"));
		action.moveToElement(tiaoguang).click().perform();
		Thread.sleep(2000);
		//0
		WebElement start=driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[4]"));
		Thread.sleep(2000);
		//100
		WebElement end=driver.findElement(By.cssSelector("span[class='sliderValueAll100___mgvgH']"));
		Thread.sleep(3000);
		moveStartToEnd(action, start, end);
		//75 
		WebElement one=driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[4]"));
		Thread.sleep(3000);
		action.dragAndDropBy(one, -37, 0).perform();
		Thread.sleep(3000);
		//下发
		driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/div/button")).click();
		Thread.sleep(3000);
		//点击模态框
		//driver.findElement(By.id("rcDialogTitle0")).click();
		//Thread.sleep(3000);
		//输入密码   ld123!@#.com
		driver.findElement(By.cssSelector("input[placeholder='请输入密码']")).sendKeys("112233");
		Thread.sleep(3000);
		//密码确定
		driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/div[1]/div[3]/button[2]")).click();
		Thread.sleep(2000);
		//关闭密码框
		driver.findElement(By.cssSelector("span[class='ant-modal-close-x']")).click();
		Thread.sleep(3000);
		//获取到tips
		String actual=getText(driver.findElement(By.xpath("/html/body/div[4]/div/span/div/div/div/div[1]/span[2]")));
		Thread.sleep(3000);
		//关闭命令框
		driver.findElement(By.xpath("//*[@id='root']/div/div[6]/div/div[2]/div[1]/span")).click();
		Thread.sleep(3000);
	
		System.out.println(actual);
		//assertPartialTextPresent("命令下发tips", "批量开关命令已下发");
	}

	protected void moveStartToEnd(Actions action, WebElement start, WebElement end) {
		action.clickAndHold(start).moveToElement(end).release().build().perform();
	}
	
	
	@DataProvider
	public Object[][] getDatas()
	{
	//	String startRow=PropertiesUtil.getNBProperties("startRow");
	//	String endRow=PropertiesUtil.getNBProperties("endRow");
	//	int start=Integer.parseInt(startRow);
	//	int end=Integer.parseInt(endRow);
		//读取出测试用例需要的各种参数
		Object[][] datas = Excel.readExcel("/rtuno.xlsx", 0, 1, 2, 2, 2);
		for (Object[] objects : datas) {
			for (Object object : objects) {
				System.out.print("[" + object + "]"); 
			}
			System.out.println(" ");
		}
		return datas;
	}
}
