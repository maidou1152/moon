package com.dywl.iot.util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Selenium工具类 工具：util tool handler manger
 * 
 * @author asus
 * @date 2018年5月23日
 * @email 810178563@qq.com
 * @desc
 */
public class SeleniumUtil {
	/**
	 * 方便的打开浏览器：ie、Chrome、firefox
	 * @param browserType
	 * @param seleniumVersion
	 * @param driverPath
	 * @return
	 */
	public static WebDriver openBrowser(String browserType, String seleniumVersion, String driverPath) {
		WebDriver driver = null;// 面向接口编程(多态)
		// 避免空指针异常--字符串的比较
		if ("ie".equalsIgnoreCase(browserType)) {
			driver = openIEBrowser(driverPath);
		} else if ("chrome".equalsIgnoreCase(browserType)) {
			driver = openChromeBrowser(driverPath);
		} else if ("firefox".equalsIgnoreCase(browserType)) {
			driver = openFirefoxBrowser(seleniumVersion, driverPath);
		}
		return driver;
	}

	/**
	 * 打开火狐浏览器的方法
	 * 1.设置火狐可执行文件的路径:webdriver.firefox.bin 
	 * D:\\Program\\Mozilla Firefox\\firefox.exe
	 * 2.X：不需要可执行的驱动文件
	   3.x:需要可执行的驱动：jdk1.8
	        我需要一个依据：Selenium的版本是多少
	 * @param seleniumVersion selenium版本
	 * @param driverPath 驱动路径
	 * @return
	 */
	private static WebDriver openFirefoxBrowser(String seleniumVersion, String driverPath) {
		System.setProperty(SystemProperty.BROWSER_BINARY, "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		if ("3.x".equalsIgnoreCase(seleniumVersion)) {
			System.setProperty("webdriver.gecko.driver", driverPath);
		}
		return new FirefoxDriver();
	}

	/**
	 * 打开谷歌浏览器的方法
	 * 
	 * @param driverPath
	 * @return
	 */
	private static WebDriver openChromeBrowser(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		//设置后台静默模式启动浏览器
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("--headless");
		return new ChromeDriver();
	}

	/**
	 * 打开IE浏览器的方法
	 * 1:
	 * 	// 设置可执行驱动的路径
		// System.setProperty("webdriver.ie.driver","src/test/resources/IEDriverServer.exe");
	 *  //驱动期望的能力、忽略IE安全设置、忽略页面缩放
	 *  //设置初始url,防止window对象
	 * @param driverPath
	 * @return
	 */
	private static WebDriver openIEBrowser(String driverPath) {
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, driverPath);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.baidu.com");
		return new InternetExplorerDriver(capabilities);
	}
}