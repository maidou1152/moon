package com.dywl.iot.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTest;

public class IframeTest extends BaseTest {

	@Test
	public void f() {
		driver.get("http://www.9991.com/");
		driver.findElement(By.partialLinkText("[切换]")).click();
		
		driver.switchTo().frame("city_set_ifr");
	
		WebElement elem=driver.findElement(By.id("province"));
		Select select=new Select(elem);
		select.getOptions().get(2).click();;
	}
}
