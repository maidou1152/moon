package com.dywl.iot.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dywl.iot.config.ExcelRowObjectConfig;
import com.dywl.iot.pojo.ApiParams;



/**
 * APi参数工具类 处理第2个sheet页
 * 
 * @author asus
 *
 */
public class ApiParamUtil {

	/**
	 * 通过apiId，获取api信息
	 */
	private static Map<String, ApiParams> apiParamsMap;

	/**
	 * 静态代码块，只读取一次
	 */
	static {
		// 加保护，判断apiParamsMap的值
		if (apiParamsMap == null) {
			apiParamsMap = new HashMap<String, ApiParams>();
		}
		//精简
		List<ApiParams> apiParam=ExcelRowObjectConfig.getApiParamsList();
		for (ApiParams apiParams : apiParam) {
			apiParamsMap.put(apiParams.getCaseId(), apiParams);
		}
		/*
		// 读取excel --》把数据保存到二维数组
		Object[][] datas = ExcelUtil.readExcelWithRowNum("/rest_info.xlsx", 1, 2, 12, 1, 4);
		// 访问1000遍？？？
		// 1:先把所有的数据读取出来
		// 循环所有的行
		// api信息数组：apiInfoArray
		for (Object[] apiParamsArray : datas) {
			ApiParams apiParams = new ApiParams();
			String caseId = "";
			int i=0;
				for (Object eachCellValue : apiParamsArray) {
				// 判断这是第几次遍历：0--》rowNum 行号      1--》caseId 2--》apiId
				if (i == 0) {
					apiParams.setRowNum(Integer.parseInt(eachCellValue.toString()));
				} else if (i == 1) {
					apiParams.setCaseId(eachCellValue.toString());
					caseId=eachCellValue.toString(); 
				}else if (i==2) {
					apiParams.setApiId(eachCellValue.toString());
				}
				else if (i==3) {
					apiParams.setRequestData(eachCellValue.toString());
				}
				else if (i==4) {
					apiParams.setExpectedReponseData(eachCellValue.toString());
				}
				i++;
			}
			apiParamsMap.put(caseId, apiParams);
		}
		
		*/
	}

	public static void main(String[] args) {
		// 1:先把所有的数据读取出来
		/*
		 * Object[][] datas = ExcelUtil.readExcel("/rest_info.xlsx", 0, 2, 14,
		 * 1, 4); for (Object[] apiInfos : datas) { for (Object apiInfo :
		 * apiInfos) { System.out.print(apiInfo.toString() + " "); }
		 * System.out.println(); }
		 */
		/*
		Object[][] datas = ExcelUtil.readExcelWithRowNum("/rest_info.xlsx", 1, 2, 12, 1, 4);
		for (Object[] apiParamsMap : datas) {
			for (Object apiParams : apiParamsMap) {
				System.out.print(apiParams.toString() + " ");
			}
			System.out.println();
		}
		*/
		/**
		 * 读取apiParams的数据
		 */
		  Set<String> keySet = apiParamsMap.keySet(); 
		  for (String key : keySet)
		  { System.out.println(apiParamsMap.get(key)); }
		 
	}

	/**
	 * 获取api变量信息
	 * @return
	 */
	public static Map<String, ApiParams> getApiParamsMap() {
		return apiParamsMap;
	}
}