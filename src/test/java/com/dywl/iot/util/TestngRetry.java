package com.dywl.iot.util;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestngRetry implements IRetryAnalyzer {

	//重试机制次数的限制
	private int maxRetryCount=2;
	//当前正在重试的次数
	private int currentRetryCount=0;
	private Logger logger=Logger.getLogger(TestngRetry.class);
	
	@Override
	public boolean retry(ITestResult result) {
		//如果retry方法返回为true-->执行重试机制
		//false -->不会执行重试
		if (currentRetryCount<maxRetryCount) {
			currentRetryCount++;
			logger.info("运行第【"+currentRetryCount+"】次重试机制");
			return true;
		}else {
			return false;
		}
	}

}
