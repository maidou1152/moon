package com.dywl.iot.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dywl.iot.base.BaseTestCry;
import com.dywl.iot.pojo.CellData;
import com.dywl.iot.util.Excel;
import com.dywl.iot.util.PropertiesUtil;

public class Cryptii extends BaseTestCry {
	
	/**
	 * 
	 * @param caseId
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getDatas")
	public void f(String caseId) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/article/div/div[1]/div[3]/div/div[2]/textarea")).clear();;
		WaitTime();
		//解析的码
		String str="03 fc e8 00 00 00 00 00 00 e8 00 00 00 00 00 00";
		driver.findElement(By.xpath("/html/body/div/article/div/div[1]/div[3]/div/div[2]/textarea")).sendKeys(caseId.toString()+str);
		//220003DC 02 ca 13 01 80 00 00 00 00 80 00 00 00 00
		//370014DD 02 97 13 01 e4 ed af 00 29 e4 ee 6f 00 1a
		//01002718 03 fc e8 00 00 00 00 00 00 e8 00 00 00 00 00 00
		//01002718 02 fc e8 00 00 65 09 00 00 e8 b4 00 46 09 b0 01
		WaitTime();
		WebElement elem=driver.findElement(By.xpath("/html/body/div/article/div/div[1]/div[1]/div/div[2]/textarea"));
		boolean flag=elem.isDisplayed();
		if (flag) {
			String resultStr=elem.getAttribute("value");
			String NBId=resultStr.substring(0,6);
			//添加数据到容器中
			Excel.dataToWriteList.add(new CellData(caseId, 4, resultStr));
			Excel.dataToWriteList.add(new CellData(caseId, 5, NBId));
			Excel.dataToWriteList.add(new CellData(caseId, 6, str));
		}
	}
	
	/**
	 * 数据提供者
	 * @return
	 */
	@DataProvider
	public Object[][] getDatas()
	{
		String startRow=PropertiesUtil.getNBProperties("startRow");
		String endRow=PropertiesUtil.getNBProperties("endRow");
		int start=Integer.parseInt(startRow);
		int end=Integer.parseInt(endRow);
		//读取出测试用例需要的各种参数
		//Object[][] datas = Excel.readExcel("/NB-deviceID.xlsx", 0, 569, 2000, 1, 1);
		//Object[][] datas = Excel.readExcel("/NB-deviceID.xlsx", 0, 2001, 2500, 1, 1);
		//Object[][] datas = Excel.readExcel("/NB-deviceID.xlsx", 0, 2501, 3500, 1, 1);
		Object[][] datas = Excel.readExcel("/NB-deviceID.xlsx", 0, start, end, 1, 1);
		for (Object[] objects : datas) {
			for (Object object : objects) {
				System.out.print("[" + object + "]"); 
			}
			System.out.println(" ");
		}
		return datas;
	}
}