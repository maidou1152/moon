package com.dywl.iot.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参数工具类
 * @author asus
 *
 */
public class ParamUtil {
	
	/**
	 * 全局数据池
	 */
	private static Map<String, String> globalData= new HashMap<String, String>(); 

	
	/**
	 * 匹配全局参数的正则表达式
	 */
	private static final String PARAM_REGEX="\\$\\{(.*?)\\}";//贪婪模式
	
	/**
	 * 
	 */
	private static final String FUN_REGEX="__(\\w*?)\\(((\\w*,?)*)\\)";
	
	
	/**
	 * 添加一个全局数据
	 * @param key
	 * @param value
	 */
	public static void addGlobalData(String key,String value) {
		globalData.put(key, value);
	}
	
	/**
	 * 获得全局变量
	 * @param key
	 * @return
	 */
	public static String getGlobalData(String key) {
		return globalData.get(key);
	}
	

	public static void main(String[] args) {
	
	/*
		//testParams();
		//
		/**
		 * 1、随机数:1-100的,XXXX
		 * 2、加密：md5(123456)、非对称加密（公钥给终端）-->加密规则（后端）--密文
		 * 
		 * 参数提交的时候，可能要对参数进行逻辑处理（字符串）
		 * __方法名（参数1，参数2，参数3...）-->__random()  __function(123,456)
		 * 正则：__(\w*?)\((\w*,?)*\)
		 * 
		String regex="__(\\w*?)\\(((\\w*,?)*)\\)";
//		String str="select count(1) from __md5Str() where mobilephone ='__random()'";
	//	String str="select count(1) from __md5Str() where mobilephone ='__random()'";
	 // String str="{\"mobilephone\":\"${mobilephone}\",\"amount\":\"__fun1(a,b,c)\"}";
	    String str="{\"mobilephone\":\"${mobilephone}\",\"amount\":\"__md5Str(abc)\"}";
		//编译这个正则表达式--得到一个模式对象
				Pattern pattern=Pattern.compile(regex);
				//进行字符串的模式匹配--得到匹配对象
				Matcher matcher=pattern.matcher(str);
				//System.out.println(matcher.find());
				while (matcher.find()) {
					System.out.println("--------------------");
					//组：用括号括起来的
					String totalStr=matcher.group(0);
					String methodName=matcher.group(1);
					String paramsName=matcher.group(2);
					/*
					for (String string : paramsArray) {
						System.out.println(string);
					}
					
					System.out.println(totalStr+"----->"+totalStr);
					System.out.println(methodName+"----->"+methodName);
					System.out.println(paramsName+"----->"+paramsName);
					//str=str.replace(totalStr, globalData.get(paramsName));
					
					//怎么调用FunctionUtil对应的方法，并且传入参数
					Class clazz=FunctionUtil.class;
					try {
						String result=null;
						if ("".equals(paramsName)) {
							Method method=clazz.getMethod(methodName);//1：参数类型的字节码数组
							result=(String) method.invoke(null);//2:实际的参数值的数组
						}
						else {
							//1:获得参数个数
							String[] paramsArray =paramsName.split(",");//参数列表，通过分割
							int length=paramsArray.length;//参数的个数
							Class[] typeArray=new Class[length];//有length个参数
							for (int i = 0; i < length; i++) {
								typeArray[i]=String.class;
							}
							Method method=clazz.getMethod(methodName,typeArray);//1：参数类型的字节码数组
							result=(String) method.invoke(null,paramsArray);//2:实际的参数值的数组
						}
						System.out.println(result);
						//替换
						str=str.replace(totalStr, result);
						System.out.println(result);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			//	System.out.println(str);
				
		*/		
		
		globalData.put("mobilephone", "188811112222");
		String str=str="{\"mobilephone\":\"${mobilephone}\",\"amount\":\"__random()\"}";
		String commStr=getCommonStr(str);
		System.out.println(commStr);
		
	}

	private static void testParams() {
		//全局数据-->存放到哪里？数据载体
		
		globalData.put("table","member");
		globalData.put("mobilephone", "13711111111");
		
		String globalPhone="13735422950";//应该要从某个地方读取出来
		String str="select count(1) from ${table} where mobilephone = '${mobilephone}'";
		//${mobilephone}
		//$和{}是特殊字符，所以需要转义：\$\{mobilephone\}
		//提取mobilephone。提取${xxx}中间的xxx
		String regex="\\$\\{(.*?)\\}";//贪婪模式
		//编译这个正则表达式--得到一个模式对象
		Pattern pattern=Pattern.compile(PARAM_REGEX);
		//进行字符串的模式匹配--得到匹配对象
		Matcher matcher=pattern.matcher(str);
		//System.out.println(matcher.find());
		while (matcher.find()) {
			//System.out.println("--------------------");
			//组：用括号括起来的
			String totalStr=matcher.group(0);
			String paramsName=matcher.group(1);
			System.out.println(totalStr+"----->"+paramsName);
			str=str.replace(totalStr, globalData.get(paramsName));
		}
		System.out.println(str);
	}

	/**
	 * 正则匹配并替换
	 * @param str
	 * @return
	 */
	public static String getCommonStr(String str) {
		Pattern pattern=Pattern.compile(PARAM_REGEX);
		//进行字符串的模式匹配--得到匹配对象
		Matcher matcher=pattern.matcher(str);
		//System.out.println(matcher.find());
		while (matcher.find()) {
			//System.out.println("--------------------");
			//组：用括号括起来的
			String totalStr=matcher.group(0);
			String paramsName=matcher.group(1);
			System.out.println(totalStr+"----->"+paramsName);
			str=str.replace(totalStr, globalData.get(paramsName));
		}
		//System.out.println(str);
	    //return str;
		return getFunctionOptStr(str);
	}
	
	/**
	 * 正则匹配请求调用相关函数进行处理，得到结果，最后完成结果的替换
	 * @param str
	 * @return
	 */
	public static String getFunctionOptStr(String str){
		
		//编译这个正则表达式--得到一个模式对象
		Pattern pattern=Pattern.compile(FUN_REGEX);
		//进行字符串的模式匹配--得到匹配对象
		Matcher matcher=pattern.matcher(str);
		//System.out.println(matcher.find());
		while (matcher.find()) {
			System.out.println("--------FUN------------");
			//组：用括号括起来的
			String totalStr=matcher.group(0);
			String methodName=matcher.group(1);
			String paramsName=matcher.group(2);
		
			System.out.println(totalStr+"----->"+totalStr);
			System.out.println(methodName+"----->"+methodName);
			System.out.println(paramsName+"----->"+paramsName);
			//怎么调用FunctionUtil对应的方法，并且传入参数
			Class clazz=FunctionUtil.class;
			try {
				String result=null;
				if ("".equals(paramsName)) {
					Method method=clazz.getMethod(methodName);//1：参数类型的字节码数组
					result=(String) method.invoke(null);//2:实际的参数值的数组
				}
				else {
					//1:获得参数个数
					String[] paramsArray =paramsName.split(",");//参数列表，通过分割
					int length=paramsArray.length;//参数的个数
					Class[] typeArray=new Class[length];//有length个参数
					for (int i = 0; i < length; i++) {
						typeArray[i]=String.class;
					}
					Method method=clazz.getMethod(methodName,typeArray);//1：参数类型的字节码数组
					result=(String) method.invoke(null,paramsArray);//2:实际的参数值的数组
				}
				System.out.println(result);
				//替换
				str=str.replace(totalStr, result);
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return str;
	}
}