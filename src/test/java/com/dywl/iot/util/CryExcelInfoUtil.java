package com.dywl.iot.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dywl.iot.config.ExcelRowObjectConfig;
import com.dywl.iot.pojo.CryExcelInfo;

public class CryExcelInfoUtil{

	/**
	 * 通过apiId，获取api信息
	 */
	private static Map<String, CryExcelInfo> cryExcelInfoMap;
	
	/**
	 * 获得cryExcelInfo信息
	 * @return
	 */
	public static Map<String, CryExcelInfo> getCryExcelInfo() {
		return cryExcelInfoMap;
	}

	/**
	 * 静态代码块，只读取一次
	 */
	static {
		//加保护，判断apiInfoMap的值
		if (cryExcelInfoMap == null) {
			cryExcelInfoMap = new HashMap<String, CryExcelInfo>();
		}
		
		List<CryExcelInfo> cryExcelInfo=ExcelRowObjectConfig.getCryExcelInfosList();
		for (CryExcelInfo cryExcelInfos : cryExcelInfo) {
			cryExcelInfoMap.put(cryExcelInfos.getSn(), cryExcelInfos);
		}
		/*
		//读取excel --》把数据保存到二维数组
		Object[][] datas = ExcelUtil.readExcel("/rest_info.xlsx", 0, 2, 14, 1, 4);
		// 1:先把所有的数据读取出来
		// 循环所有的行
		//api信息数组：apiInfoArray
		for (Object[] apiInfoArray : datas) {
			ApiInfo apiInfo = new ApiInfo();
			// 循环当前行的每一列-->第一列apiID
			int i = 0;
			// 遍历当前行的每一列：apiId apiName type url
			String apiId = "";
			//apiInfoArray 是某一行的所有字段，遍历每一列 
			for (Object eachCellValue : apiInfoArray) {
				//判断这是第几次遍历：0--rowNum 行号   1--》apiId 2--》apiName 3--》type 4--》url
				if (i == 0) {
					//行号
				//	apiInfo.setRowNum(Integer.parseInt((String) eachCellValue));	
					
					apiInfo.setApiId(eachCellValue.toString());
					apiId = eachCellValue.toString();
					
				} else if (i == 1) { 
					apiInfo.setApiName(eachCellValue.toString());
				} else if (i == 2) {
					apiInfo.setType(eachCellValue.toString());
				} else if (i == 3) {
					apiInfo.setUrl(eachCellValue.toString());
				}
				i++;
			}
			apiInfoMap.put(apiId, apiInfo);
			// 第一列是apiID
		}
		*/
	}

	
	public static void main(String[] args) {
		// 1:先把所有的数据读取出来

		Object[][] datas = ExcelUtil.readExcel("/NB-deviceID.xlsx", 0, 2, 12, 1, 4);
		for (Object[] apiInfos : datas) {
			for (Object apiInfo : apiInfos) {
				System.out.print(apiInfo.toString() + " ");
			}
			System.out.println();
		}

		/*
		  Set<String> keySet = cryExcelInfoMap.keySet(); 
		  for (String key : keySet) {
		  System.out.println(cryExcelInfoMap.get(key)); }
		  
		  */
	}
}
