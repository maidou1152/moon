package com.dywl.iot.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.dywl.iot.util.Excel;
import com.dywl.iot.util.SeleniumUtil;

/**
 * 基础测试类
 * @author asus
 *
 */
public class BaseTestCry {
	
	/**
	 * 不加static:对象属性
	 * 加static:类属性、静态属性  当这个类被加载到jvm中间会首先初始化，在内存中只会有一份
	 */
	protected static WebDriver driver=null;
	
	@BeforeSuite
	//把testng.xml中间的参数给注入进入
	@Parameters(value={"browserType","seleniumVersion","driverPath"})
	public void case01(String browserType,String seleniumVersion,String driverPath) {
		driver= SeleniumUtil.openBrowser(browserType, seleniumVersion, driverPath);
		/*
		String url="http://183.129.159.166:10056/login";
		driver.get(url);
		driver.findElement(By.id("name")).sendKeys("admin");
		WebElement inputPassword=driver.findElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		inputPassword.sendKeys("123456");
		WebElement loginButton=driver.findElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
		driver.manage().window().maximize();
		WaitTime();
		driver.findElement(By.partialLinkText("运行")).click();
		WaitTime();
		driver.findElement(By.partialLinkText("配电箱")).click();
		WaitTime();
		*/
		driver.manage().window().maximize();
		driver.get("https://cryptii.com");
		WaitTime();
		driver.findElement(By.linkText("DECODE")).click();
		WaitTime();
		driver.findElement(By.xpath("/html/body/div/article/div/div[1]/div[2]/div/header/h3/button")).click();
		WaitTime();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/ul/li[6]/ul/li[2]/button/span")).click();
		driver.findElement(By.xpath("/html/body/div/article/div/div[1]/div[1]/div/div[2]/textarea")).clear();
		WaitTime();
		driver.findElement(By.xpath("/html/body/div/article/div/div[1]/div[3]/div/header/h3/button")).click();
		WaitTime();
		driver.findElement(By.xpath("//span[contains(text(),'Bytes')]")).click();
		WaitTime();
	}
	
	@AfterSuite
	public void afterSuite() {
		//Excel.batchWriteData("/NB-deviceID.xlsx","target/test-classes/NB-deviceID_2501_3500_00.xlsx",0);
//		Excel.batchWriteData("/NB-deviceID.xlsx","target/test-classes/NB-deviceID_3500_5000_00.xlsx",0);
	//	Excel.batchWriteData("/NB-deviceID.xlsx","target/test-classes/NB-deviceID_5001_10000_00.xlsx",0);
		Excel.batchWriteData("/NB-deviceID.xlsx","target/test-classes/NB-deviceID_1_5000_01.xlsx",0);
	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/**
	 * 智能查找元素
	 * @param timeOutInSeconds  等待时间
	 * @param by  查找方式
	 * @return
	 */
	protected WebElement getElement(long timeOutInSeconds, By by) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver arg0) {
				return driver.findElement(by);
			}
		});
		return element;
	}
	
	/**
	 * 智能查找元素
	 * @param by
	 * @return
	 */
	protected WebElement getElement(By by) {
		return getElement(5, by);
	}
	
	/**
	 * 智能查找元素列表
	 * @param timeOutInSeconds  等待时间
	 * @param by  查找方式
	 * @return
	 */
	protected List<WebElement> getElements(long timeOutInSeconds, By by) {
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		List<WebElement> elements=wait.until(new ExpectedCondition<List<WebElement>>() {
			@Override
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(by);
			}
		});
		return elements;
	}
	
	/**
	 * 智能查找元素列表、默认等待时间为5s
	 * @param by
	 * @return
	 */
	protected List<WebElement> getElements(By by) {
		return getElements(5, by);
	}

	/**
	 * 硬性等待
	 */
	protected void WaitTime() {
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}