package com.dywl.iot.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dywl.iot.base.Locator;
import com.dywl.iot.testCase.RTU.RTU_Add_Page;

public class PagesUtil {

	public	static Map<String, Map<String, Locator>> pagesMap = null;
	
	
	/**
	 * 
	 */
	static {
		loadPages();
	}
	
	/**
	 * 加载所有页面的ui元素
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Map<String, Locator>>  loadPages() {
		//xml
		SAXReader reader=new SAXReader();
		// 通过reader读取xml文件
		try {
			// 得到文档对象
			Document document=reader.read(PagesUtil.class.getResourceAsStream("/pages.xml"));
			// 获得根标签（元素）
			Element element = document.getRootElement();
			// 获得这个根元素下所有我想要的元素--page标签
			List<Element> pagesElements = element.elements("page");
			// 创建一个map，用来存放所有的页面map,value是每个页面的map信息，key为页面的名称
			// 告诉我一个页面的名称，就能把这个页面找到，
			// 告诉我某个元素的描述，就能找到这个元素
			pagesMap = new HashMap<String, Map<String, Locator>>();
			for (Element pagesElement : pagesElements) {
				// 获得每个page标签下的locator标签
				List<Element> locatorElements=pagesElement.elements("locator");
				// 得到当前页面的名称
				String pageName = pagesElement.attributeValue("name");
				// 创建一个列表，存储每个页面的locator
			//	List<Locator> locators = new ArrayList<Locator>();
				// 通过注册按钮的标识，就能找到注册按钮-->locator
				// 用来保存当前页面每个locator,key为locator的desc属性，
				// 这样子可以非常方便的通过描述信息就能找到这个locator
				// 这个map具有这个页面的所有元素信息
				Map<String, Locator> locatorsMap = new HashMap<String, Locator>();
				//遍历每个locater
				for (Element locatorElement : locatorElements) {
					//获取每个locator的详细信息
					//定位方式
					String by = locatorElement.attributeValue("by");
					//定位的值
					String value = locatorElement.attributeValue("value");
					//元素的描述
					String desc = locatorElement.attributeValue("desc");
					//System.out.println(by+","+value+","+desc);
					// 封装到locator
					Locator locator = new Locator(by, value, desc);
					// 把每个locator用key--value的形式保存起来
					locatorsMap.put(desc, locator);
				}
				pagesMap.put(pageName, locatorsMap);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return pagesMap;
	}
	
	
	public static void main(String[] args) {
		
		/*Map<String, Map<String, Locator>> pagesMap = loadPages();
		// 我要找到注册页面的注册按钮
		Locator pa=pagesMap.get("iot登录页面").get("用户名输入框");
		Locator pa1=pagesMap.get("iot登录页面").get("密码输入框");
		System.out.println("-------------");
		System.out.println(pa);
		System.out.println(pa1);*/
		//反射
		//如果要得到一个类的细节，首先要拿到一个字节码对象，这个字节码对象就具有这个类的所有的细节
		//1:通过对象来获得，对象.getClass()
		RTU_Add_Page page=new RTU_Add_Page();
		System.out.println(page.getClass().getName());
		System.out.println(	page.getClass().getSimpleName());
		//2.类.class
		Class<RTU_Add_Page> clazs=RTU_Add_Page.class;
		System.out.println(clazs.getSimpleName());
	
		
	}
}
