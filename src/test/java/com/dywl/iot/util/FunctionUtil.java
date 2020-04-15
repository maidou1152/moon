package com.dywl.iot.util;

import java.util.Random;

/**
 * 方法工具类
 * @author asus
 *
 */
public class FunctionUtil {
	/**
	 * 返回一个正确的投资额（100的正整数倍）
	 * @return
	 */
	public static String random() {
		
		Random random=new Random();
		return random.nextInt(100)*100+"";
	}
	
	public static String md5Str(String str) {
		return "java4期你们好"+str;
	}
	
	public static String fun1(String str1,String str2,String str3) {
		return str1+str2+str3;
	}
	
	public static String fun1(String str1,String str2,String str3,String str4) {
		return "";
	}

	public static void main(String[] args) {
		System.out.println(random());
	}
}
