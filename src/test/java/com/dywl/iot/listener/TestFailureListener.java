package com.dywl.iot.listener;

import java.io.File;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.dywl.iot.util.ScreenshotUtil;

public class TestFailureListener extends TestListenerAdapter {

	/**
	 * 发现测试用例失败截图
	 */
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.println("---------发现测试用例失败-------------");
		//思路：当测试用例执行失败，我要使用TakesScreenshot(子类实现了这个接口)进行截图
		//截图的各个操作在这里写好么-->一个具体的业务
		//获得surefire-reports套件目录
		String outputDirectory=tr.getTestContext().getOutputDirectory();
		System.out.println(outputDirectory);
		//当前套件的报告路径
		//F:\workspace\phoenix_web_auto_4\target\surefire-reports\Suite
		//重0开始截取，截取到最后一个\的索引位置
		String surefirDir=outputDirectory.substring(0,outputDirectory.lastIndexOf("\\"));
		//拿到test的名称
		String testName=tr.getTestContext().getCurrentXmlTest().getName();
		//截屏的目录
		//F:\workspace\phoenix_web_auto_4\target\surefire-reports\screenshot
		String screenshotDir=surefirDir+File.separator+"screenshot"+File.separator+testName;
		//不同的test的截屏文件保存到不同的目录下
		
		//使用工具类进行截屏
		File screenshotFile=ScreenshotUtil.takeScreenshot(screenshotDir);
		
		//我要把一个截图展示在一个网页上？怎么渲染到网页上--标签
		//完整的图片url:http://localhost:8765/screenshot/register/1534643245630.jpg
		//怎么把这个信息加入到reportng的报表信息中
		
		//截图文件的绝对路径   
		//F:\workspace\phoenix_web_auto_4\target\surefire-reports\screenshot\register\1534678755243.jpg
		String absolutePath=screenshotFile.getAbsolutePath();
		//本地文件路径
	//	String baseURL="http://47.98.164.194:8888/";
		//F:\workspace20190409\web_auto\target\surefire-reports
	//	String baseURL="F:\\workspace20190409\\web_auto\\target\\surefire-reports";
		String baseURL="http://localhost:8888/";
		String oldChar=absolutePath.substring(0,absolutePath.indexOf("screenshot"));
	
		String urlTemp=absolutePath.replace(oldChar, baseURL);
		String imageURL =urlTemp.replace("\\", "/");
		
		//调用Reporter的log方法记录下截屏图片的访问路径，报表处理类就能取出这个信息渲染出来
		//Reporter.log("<img src='"+accessPath+"' height='100' width='100'><a href='"+accessPath+"' target='_blank'>点击查看大图</a></img>")
		//String accessPath="http://localhost:8888/screenshot/register/1534643245630.jpg";
		String imageLogTag="<img src='"+imageURL+"' height='80' width='100'><a href='"+imageURL+"'target='_blank'>点击查看大图</a></img>";
		Reporter.log(imageLogTag);
		
	}
	public static void main(String[] args) {
		//调用Reporter的log方法记录下截屏图片的访问路径，报表处理类就能取出这个信息渲染出来
	/*	Reporter.log("<img src='"+accessPath+"' height='100' width='100'><a href='"+accessPath+"'target='_blank'>点击查看大图</a></img>")
		String accessPath="http://localhost:8888/screenshot/register/1534643245630.jpg";
		String imageLogStr="<img src='"+accessPath+"' height='100' width='100'><a href='"+accessPath+"'target='_blank'>点击查看大图</a></img>";
		System.out.println(imageLogStr);*/
		
		String absolutePath="F:\\workspace20190409\\web_auto\\target\\surefire-reports\\screenshot\\login\\1568793333957.jpg";
		String baseURL="http://localhost:8888/";
		String oldChar=absolutePath.substring(0,absolutePath.indexOf("screenshot"));
		String urlTemp=absolutePath.replace(oldChar, baseURL);
		String url =urlTemp.replace("\\", "/");
		System.out.println(url);
	}
}