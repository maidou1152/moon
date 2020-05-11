package com.dywl.iot.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.dywl.iot.base.BaseTest;


/**
 * 截图工具类
 * @author asus
 *
 */
public class ScreenshotUtil {
	/**
	 * 日志：log4j
	 */
	private static Logger logger = Logger.getLogger(ScreenshotUtil.class);

	/**
	 * 截屏的方法
	 * @param screenshotDir  图片存储路径
	 * @return 
	 */
	public static File takeScreenshot(String screenshotDir) {
		//拿到driver
		WebDriver driver = BaseTest.getDriver();
		// 当前时间
		Date date = new Date();
		// 获得毫秒值
		long time = date.getTime();
		// 文件名称
		String filename = time + ".jpg";
		// 如果这个driver是ChromeDriver的一个实例
		logger.info("开始截屏");
		// 强制转换为接口类型
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		// 源文件
		File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		// 创建一个目标文件
		File destFile = new File(screenshotDir + File.separator + filename);
		// 把截屏保存到screenshotDir这个目录中去
		try {
			logger.info("开始拷背截屏到目标路径中去");
			FileUtils.copyFile(screenshotFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}

	@Deprecated
	public static void takeScreenshot2(String screenshotDir) {
		WebDriver driver = BaseTest.getDriver();
		// 当前时间
		Date date = new Date();
		// 获得毫秒值
		long time = date.getTime();
		// 文件名称
		String filename = time + ".jpg";
		// 如果这个driver是ChromeDriver的一个实例
		File screenshotFile = null;
		logger.info("开始截屏");
		if (driver instanceof ChromeDriver) {
			// 强转
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			// 截图:这是源文件
			screenshotFile = chromeDriver.getScreenshotAs(OutputType.FILE);
		} else if (driver instanceof FirefoxDriver) {
			// 强转
			FirefoxDriver firefoxDriver = (FirefoxDriver) driver;
			// 截图:这是源文件
			screenshotFile = firefoxDriver.getScreenshotAs(OutputType.FILE);
		} else if (driver instanceof InternetExplorerDriver) {
			// 强转
			InternetExplorerDriver internetExplorerDriver = (InternetExplorerDriver) driver;
			// 截图:这是源文件
			screenshotFile = internetExplorerDriver.getScreenshotAs(OutputType.FILE);
		}
		File destFile = new File(screenshotDir + File.separator + filename);
		// 把截屏保存到screenshotDir这个目录中去
		try {
			logger.info("开始拷背截屏到目标路径中去");
			FileUtils.copyFile(screenshotFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 失效
	@Deprecated
	public static void takeScreenshot3(String screenshotDir) {
		WebDriver driver = BaseTest.getDriver();
		// 当前时间
		Date date = new Date();
		// 获得毫秒值
		long time = date.getTime();
		// 文件名称
		String filename = time + ".jpg";

		// 如果这个driver是ChromeDriver的一个实例
		if (driver instanceof ChromeDriver) {
			// 强转
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			// 截图:这是源文件
			File screenshotFile = chromeDriver.getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotDir + File.separator + filename);
			// 把截屏保存到screenshotDir这个目录中去
			try {
				logger.info("开始拷背截屏到目标路径中去");
				FileUtils.copyFile(screenshotFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (driver instanceof FirefoxDriver) {
			// 强转
			FirefoxDriver firefoxDriver = (FirefoxDriver) driver;
			// 截图:这是源文件
			File screenshotFile = firefoxDriver.getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotDir + File.separator + filename);
			// 把截屏保存到screenshotDir这个目录中去
			try {
				logger.info("开始拷背截屏到目标路径中去");
				FileUtils.copyFile(screenshotFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (driver instanceof InternetExplorerDriver) {
			// 强转
			InternetExplorerDriver internetExplorerDriver = (InternetExplorerDriver) driver;
			// 截图:这是源文件
			File screenshotFile = internetExplorerDriver.getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotDir + File.separator + filename);
			// 把截屏保存到screenshotDir这个目录中去
			try {
				logger.info("开始拷背截屏到目标路径中去");
				FileUtils.copyFile(screenshotFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		Date date2 = new Date();
		System.out.println(date2.getTime());
	}
}