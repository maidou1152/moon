package com.dywl.iot.config;

import java.util.List;

import com.dywl.iot.pojo.ApiInfo;
import com.dywl.iot.pojo.ApiParams;
import com.dywl.iot.pojo.CryExcelInfo;
import com.dywl.iot.util.ExcelUtil;

/**
 * 配置的思想
 *  需要啥对象，交给我来维护，其他地方只要拿来用就可以了--依赖注入
 *  
 * @author asus
 *
 */
public class ExcelRowObjectConfig {

	private static List<ApiInfo> apiInfoList;
	private static List<ApiParams> apiParamsList;
	
	private static List<CryExcelInfo> cryExcelInfosList;

	static {

		// 加载所有的apiInfo对象
		apiInfoList = (List<ApiInfo>) ExcelUtil.read("/NB-deviceID.xlsx", 0, ApiInfo.class);
		apiParamsList = (List<ApiParams>) ExcelUtil.read("/NB-deviceID.xlsx", 1, ApiParams.class);
		cryExcelInfosList=(List<CryExcelInfo>) ExcelUtil.read("", 0, CryExcelInfo.class);
	}

	public static List<CryExcelInfo> getCryExcelInfosList() {
		return cryExcelInfosList;
	}

	public static List<ApiInfo> getApiInfoList() {
		return apiInfoList;
	}

	public static List<ApiParams> getApiParamsList() {
		return apiParamsList;
	}
	/**
	 * 获得数据提供者需要的参数
	 * @return
	 */
	public static Object[][] getApiParameters() {
		int size =apiParamsList.size();
		Object[][] datas=new Object[size][6];//容器-->数据提供者
		for (int i = 0; i < size; i++) {
			ApiParams apiParams=apiParamsList.get(i);
			//二维数组的第一个元素
			datas[i][0]=apiParams.getCaseId();
			datas[i][1]=apiParams.getApiId();
			datas[i][2]=apiParams.getRequestData();
			datas[i][3]=apiParams.getExpectedReponseData();
			datas[i][4]=apiParams.getPreValidateSql();
			datas[i][5]=apiParams.getAfterValidateSql();
		}
		return datas;
	}
	
	/**
	 * 数据提供者
	 * @return
	 */
	public static Object[][] getCryExcelInfo() {
		int size =cryExcelInfosList.size();
		Object[][] datas=new Object[size][1];//容器-->数据提供者
		for (int i = 0; i < size; i++) {
			CryExcelInfo cryExcelInfo=cryExcelInfosList.get(i);
			//二维数组的第一个元素
			datas[i][0]=cryExcelInfo.getSn();
		}
		return datas;
	}
	
}
