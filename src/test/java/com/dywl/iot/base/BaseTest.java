package com.dywl.iot.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.dywl.iot.listener.TestngListener;
import com.dywl.iot.util.PagesUtil;
import com.dywl.iot.util.PropertiesUtil;
import com.dywl.iot.util.SeleniumUtil;

/**
 * 基础测试类
 * @author asus
 *
 */
@Listeners({TestngListener.class})
public class BaseTest {
	
	/**
	 * log4j日志
	 */
	private static Logger logger=Logger.getLogger(BaseTest.class);
	
	
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
		//String url="http://183.129.159.166:10056/login";
		login();
	}

	/**
	 * 用户登录
	 */
	private void login() {
		to("iotLogin");
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		driver.findElement(By.id("name")).sendKeys("admin327");
		WebElement inputPassword=driver.findElement(By.id("password"));
		new Actions(driver).moveToElement(inputPassword).perform();
		//112233  ld123!@#.com
		inputPassword.sendKeys("12345678!");
		WebElement loginButton=driver.findElement(By.tagName("button"));
		new Actions(driver).moveToElement(loginButton).perform();
		loginButton.click();
	}
	
	@AfterSuite
	public void afterSuite() {
	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//driver.quit();
	}
	
	/**
	 * 智能查找元素
	 * @param timeOutInSeconds  等待时间
	 * @param by  查找方式
	 * @return
	 */
	protected WebElement getElement(long timeOutInSeconds, final By by) {
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
	 * 智能查找元素(通用性方法)
	 * @param by
	 * @return
	 */
	protected WebElement getElement(By by) {
		return getElement(20, by);
	}
	
	/**
	 * 智能查找元素、默认等待5s
	 * @param keyword 关键字
	 * @return
	 */
	protected WebElement getElement(String keyword) {
		return getElement(keyword,10,this.getClass());
	}
	
	/**
	 * 访问指定页面
	 * @param keyword
	 * @param clazz
	 * @return
	 */
	protected WebElement getElement(String keyword,Class<?> clazz) {
		return getElement(keyword,50,clazz);
	}
	
	/**
	 * 智能查找元素
	 * @param keyword 关键字
	 * @param timeOutInSeconds  超时时间
	 * @return
	 */
	protected WebElement getElement(String keyword,long timeOutInSeconds,Class<?> pageclazz) {
	//	Locator locator=PagesUtil.pagesMap.get(this.getClass().getName()).get(keyword);
	//	Locator locator=PagesUtil.pagesMap.get(pageclazz.getName()).get(keyword);
		Locator locator=PagesUtil.loadPages().get(pageclazz.getName()).get(keyword);
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		WebElement element=wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver arg0) {
				//通过locator信息，创建一个by
				String byStr=locator.getBy();
				String value=locator.getValue();
				//String desc=locator.getDesc();
				//By by=null;
				/*if ("id".equals(byStr)) {
					by=By.id(value);
				}else if ("name".equals(byStr)) {
					by=By.name(value);
				}else if ("tagName".equals(byStr)) {
					by=By.tagName(value);
				}else if ("className".equals(byStr)) {
					by=By.className(value);
				}else if ("cssSelector".equals(byStr)) {
					by=By.cssSelector(value);
				}else if ("partialLinkText".equals(byStr)) {
					by=By.partialLinkText(value);
				}else if ("linkText".equals(byStr)) {
					by=By.linkText(value);
				}else if ("xpath".equals(byStr)) {
					by=By.xpath(value);
				}*/
				
				By by=null;
				//By类中的方法
				try {
					//不管你是id,name,cssSelector  这些都是By类中的方法
					//字节码得到By类的细节
					Class<By> clazz=By.class;
					//方法的细节:id name
					//得到by的一个静态方法
					Method  byMethod=clazz.getMethod(byStr,String.class);
					//执行这个方法
					by=(By) byMethod.invoke(null, value);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				return driver.findElement(by);
			}
		});
		return element;
	}
	
	/**
	 * 智能查找元素列表、默认等待5s
	 * 当前页面
	 * @param keyword 关键字
	 * @return
	 */
	protected List<WebElement> getElements(String keyword) {
		return getElements(keyword,5,this.getClass());
	}
	
	/**
	 * 智能查找元素列表、默认等待5s
	 * 指定页面
	 * @param keyword
	 * @param pageclazz  
	 * @return
	 */
	protected List<WebElement> getElements(String keyword,Class<?> pageclazz) {
		return getElements(keyword,5,pageclazz);
	}
	
	/**
	 * 智能查找元素
	 * @param keyword  关键字
	 * @param timeOutInSeconds  超时时间
	 * @return
	 */
	protected List<WebElement> getElements(String keyword,long timeOutInSeconds,Class<?> pageclazz) {
		//Locator locator=PagesUtil.pagesMap.get(pageclazz.getName()).get(keyword);
		Locator locator=PagesUtil.loadPages().get(pageclazz.getName()).get(keyword);
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		List<WebElement> elements=wait.until(new ExpectedCondition<List<WebElement>>() {
			@Override
			public List<WebElement> apply(WebDriver arg0) {
				//通过locator信息，创建一个by
				String byStr=locator.getBy();
				String value=locator.getValue();
			//	String desc=locator.getDesc();
				By by=null;
				//By类中的方法
				Class<By> clazz=By.class;
				try {
					//得到by的一个静态方法
					Method  byMethod=clazz.getMethod(byStr,String.class);
					//执行这个方法
					by=(By) byMethod.invoke(null, value);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				return driver.findElements(by);
			}
		});
		return elements;
	}
	
	/**
	 * 打开一个页面
	 * @param url 页面的地址
	 */
	protected void to(String urlStr) {
		String url=PropertiesUtil.getURL(urlStr);
		logger.info("打开页面：["+urlStr+"]");
		driver.navigate().to(url);
	}

	/**
	 * 
	 * @param url
	 */
	protected void go(String url) {
		String urlStr=PropertiesUtil.getURL(url);
		logger.info("打开页面：["+urlStr+"]");
		driver.navigate().to(urlStr);
	}
	
	/**
	 * 窗口最大
	 */
	protected void maxWindow() {
		logger.info("窗口最大化");
		driver.manage().window().maximize();
	}
	
	/**
	 * 刷新
	 */
	protected void refresh() {
		logger.info("页面刷新");
		driver.navigate().refresh();
	}
	
	/**
	 * 前进
	 */
	protected void forward() {
		logger.info("前进");
		driver.navigate().forward();
	}
	
	/**
	 * 后退
	 */
	protected void back() {
		logger.info("后退");
		driver.navigate().back();
	}
	
	/**
	 * 在当前页面输入内容
	 * @param keyWord 要输入的内容
	 * @param content 输入框
	 */
	protected void type(String keyWord,String content) {
		type(keyWord, content, this.getClass());
	}
	
	/**
	 * 在指定页面输入内容
	 * @param keyWord 要输入的内容
	 * @param content 输入框
	 */
	protected void type(String keyWord,String content,Class<?> pageclazz) {
		logger.info("往["+keyWord+"]元素写入内容:["+content+"]");
		WebElement webElement=getElement(keyWord,pageclazz);
		webElement.sendKeys(content);
	}
	
	/**
	 * 点击当前页面的元素
	 * @param webElement 要点击的元素
	 */		
	protected void click(String keyword) {
		click(keyword, this.getClass());
	}
	
	/**
	 * 单击某个页面的元素
	 * @param webElement 要点击的元素
	 */		
	protected void click(String keyword,Class<?> pageclazz) {
		logger.info("单击元素:["+keyword+"]");
		WebElement webElement=getElement(keyword,pageclazz);
		webElement.click();
	}
	
	/**
	 * 获取当前页面元素的文本
	 * @param webElement
	 * @return
	 */
	protected String getText(String keyword) {
		return getText(keyword, this.getClass());
	}
	
	/**
	 * 获取指定页面元素的文本
	 * @param webElement
	 * @return
	 */
	protected String getText(String keyword,Class<?> pageclazz) {
		WebElement webElement=getElement(keyword,pageclazz);
		String  text=webElement.getText();
		logger.info("获取到的元素["+keyword+"]的文本内容："+text);
		return text;
	}
	
	protected String getText(WebElement webElement) {
		String  text=webElement.getText();
		logger.info("获取到的元素["+webElement+"]的文本内容："+text);
		return text;
	}
	
	/**
	 * 鼠标移动事件
	 * @param webElement
	 */
	protected void moveToElement(String keyword,Class<?> pageclazz) {	
		WebElement webElement=getElement(keyword,pageclazz);
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).perform();
		actions.click(webElement).perform();
		logger.info("获取到的元素["+keyword+"]");
	}
	
	/**
	 * 当前页面的鼠标移动事件
	 * @param keyword
	 */
	protected void moveToElement(String keyword) {
		 moveToElement(keyword,this.getClass());	
	}
	
	/**
	 * 当前页面,鼠标从一个元素移动另一个元素
	 * @param startkeyword
	 * @param endkeyword
	 */
	protected void moveStartToEnd(String startkeyword,String endkeyword) {
		moveStartToEnd(startkeyword, endkeyword,this.getClass());
	}
	
	/**
	 * 指定页面,鼠标从一个元素移动另一个元素
	 * @param startkeyword
	 * @param endkeyword
	 * @param pageclazz
	 */
	protected void moveStartToEnd(String startkeyword,String endkeyword,Class<?> pageclazz){
		Actions actions=new Actions(driver);
		WebElement startwebElement=getElement(startkeyword,pageclazz);
		WebElement endwebElement=getElement(endkeyword,pageclazz);
		logger.info("获取到的开始元素["+startkeyword+"]");
		logger.info("获取到的结束元素["+endkeyword+"]");
		actions.clickAndHold(startwebElement).moveToElement(endwebElement).release().build().perform();
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
	
	/**
	 * 断言页面元素文本值为某文本
	 * @param keyWord
	 * @param expectedText
	 */
	protected void assertTextPresent(String keyword,String expectedText,Class<?> pageclazz){
		String actualText=getText(keyword,pageclazz);
		Assert.assertEquals(actualText, expectedText);
	}
	
	protected void assertTextPresent(String keyword,String expectedText){
		assertElementEditable(keyword, this.getClass());
	}
	
	/**
	 * 断言页面元素文本值包含某文本
	 * @param keyword
	 * @param expectedText
	 */
	protected void assertPartialTextPresent(String keyword,String expectedText,Class<?> pageclazz){
		String actualText=getText(keyword,pageclazz);
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	/**
	 * 断言当前页面元素文本值包含某文本
	 * @param keyword
	 * @param expectedText
	 */
	protected void assertPartialTextPresent(String keyword,String expectedText){
		logger.info("获取到的元素["+keyword+"]"+"内容：["+expectedText+"]");
		assertPartialTextPresent(keyword,expectedText,this.getClass());
	}
	
	/**
	 * 断言指定页面元素启用状态
	 * @param keyword
	 * @param expectedText
	 */
	protected void assertElementEditable(String keyword,Class<?> pageclazz){
		WebElement element=getElement(keyword,pageclazz);
		Assert.assertTrue(element.isEnabled());
	}
	
	/**
	 * 断言当前页面元素启用状态
	 * @param keyword
	 */
	protected void assertElementEditable(String keyword){
		assertElementEditable(keyword, this.getClass());
	}
	
	/**
	 * 断言指定页面当前URL包含
	 * 
	 */
	protected void assertURLContains(String keyword,String expectedText,Class<?> pageclazz) {
		String actualText=getText(keyword,pageclazz);
		Assert.assertTrue(actualText.contains(expectedText));
	}

	/**
	 * 断言当前页面URL包含
	 * @param keyword
	 * @param expectedText
	 */
	protected void assertURLContains(String keyword,String expectedText){
		assertURLContains(keyword, expectedText, this.getClass());
	}
	
	//assertTextPresent
	/**
	 * 
	 * @param keyword
	 */
	protected void assertTextPresent(String keyword) {
	}
	
	//assertTextNotPresent
	/**
	 * 当前显示的页面上是否没有出现指定的文本
	 * @param keyword
	 */
	protected void assertTextNotPresent(String keyword,String expectedText) {
		String actualText= getText(keyword);
//		Assert.assertTrue(actualText.equals(expectedText));
		Assert.assertFalse(actualText.contains(expectedText));
	}
	
	/**
	 * 提供driver
	 * @return
	 */
	public static  WebDriver getDriver() {
		return driver;
	}
}