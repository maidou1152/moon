package com.dywl.iot.util;

import java.io.IOException;
import java.util.Properties;


public class PropertiesUtil {
	
	/**
	 * 用来加载url属性文件的对象
	 */
	private static Properties urlProperties;
	/**
	 * 用来加载NB的配置文件
	 */
	private static Properties NBProperties;
	/**
	 * 用来加载rtu编号的配置文件
	 */
	private static Properties rtunoProperties;
	
	/**
	 * 用来加载工单系统的url地址
	 */
	private static Properties urlworkProperties;

	static {
		LoadProperties();
	}

	/**
	 * 加载properties文件的方法
	 */
	private static void LoadProperties() {
		try {
			if (urlProperties == null) {
				urlProperties = new Properties();
			}
			urlProperties.load(PropertiesUtil.class.getResourceAsStream("/url.properties"));
			if (NBProperties == null) {
				NBProperties = new Properties();
			}
			NBProperties.load(PropertiesUtil.class.getResourceAsStream("/NB.properties"));
			if ( rtunoProperties== null) {
				rtunoProperties = new Properties();
			}
			rtunoProperties.load(PropertiesUtil.class.getResourceAsStream("/rtuno.properties"));
			if (urlworkProperties == null) {
				urlworkProperties = new Properties();
			}
			urlworkProperties.load(PropertiesUtil.class.getResourceAsStream("/workurl.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取配置文件里的url
	 * @param urlKey
	 * @return
	 */
	public static String getURL(String urlKey) {
		return urlProperties.getProperty(urlKey);
	}

	/**
	 * 获取配置文件里的开始行、结束行
	 * @param String
	 * @return
	 */
	public static String getNBProperties(String String) {
		return NBProperties.getProperty(String);
	}

	/**
	 * 
	 * @param urlKey
	 * @return
	 */
	public static String getworkurlProperties(String urlKey) {
		return urlworkProperties.getProperty(urlKey);
	}
	
	/**
	 * example
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(urlProperties.getProperty("registerURL"));
		System.out.println(NBProperties.getProperty("startRow"));
		System.out.println(NBProperties.getProperty("endRow"));
		System.out.println(urlworkProperties.get("workLogin"));
		System.out.println(rtunoProperties.get("endRow"));
	}
}