package com.dywl.iot.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.dywl.iot.util.TestngRetry;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		//1、拿到@Test注解的retryAnalyzer属性对象
		IRetryAnalyzer iRetryAnalyzer=annotation.getRetryAnalyzer();
		//2.如果@Test的retrynalyzer属性没有设置对象，iRetryAnalyzer=null
		if (iRetryAnalyzer==null) {
			annotation.setRetryAnalyzer(TestngRetry.class);
		}
	}

}
