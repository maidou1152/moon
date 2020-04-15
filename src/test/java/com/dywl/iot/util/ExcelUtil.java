package com.dywl.iot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dywl.iot.pojo.ApiInfo;
import com.dywl.iot.pojo.ApiParams;
import com.dywl.iot.pojo.CellData;
import com.dywl.iot.pojo.CryExcelInfo;
import com.dywl.iot.pojo.ExcelRowObject;



public class ExcelUtil {

	/**
	 * 收集要写的数据的容器，容器中就是一个一个要写的数据对象CellData
	 */
	public static List<CellData> dataToWriteList = new ArrayList<CellData>();

	// 反向测试用例：数据保存在resource底下的regeister.xlsx文件的第2行到第7行
	// 确定数据是哪一行到哪一行，哪一列到哪一列 (shift+alt+a)
	/**
	 * 读取excel,包含行号
	 * 
	 * @param excelPath
	 *            文件路径
	 * @param sheetIndex
	 *            sheet的索引
	 * @param startRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param starCell
	 *            开始列
	 * @param endCell
	 *            结束列
	 * @return 二维数组
	 */
	public static Object[][] readExcelWithRowNum(String excelPath, int sheetIndex, int startRow, int endRow,
			int startCell, int endCell) {
		// 创建一个二维数组
		// 第2行到第7行 第1列到第4列
		// 1到2有几个数字 2 （2-1）+1=1
		// 2到5有几个数字 4 （5-2）+1=4
		Object[][] datas = new Object[endRow - startRow + 1][endCell - startCell + 2];
		// 1:获得Excel文件输入流(加载资源作为流)
		InputStream is = ExcelUtil.class.getResourceAsStream("/rest_info.xlsx");
		try {
			// 2:获得工作簿--面向接口编程
			Workbook workbook = WorkbookFactory.create(is);
			// 3:得到工作簿
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 4：操作sheet
			for (int i = startRow; i <= endRow; i++) {
				// 6:得到每一行
				Row row = sheet.getRow(i - 1);
				// 每行的行号设置到每一行的数组的第一个元素
				datas[i - startRow][0] = i;
				// System.out.print("这是第"+i);
				// 7:得到每一行的每一列
				for (int j = startCell; j <= endCell; j++) {
					// 8:得到当前遍历的cell
					Cell cell = row.getCell(j - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					// 9:把所有的列的类型都设置为String类型
					cell.setCellType(CellType.STRING);
					String cellValue = cell.getStringCellValue();
					// 当i等于startRow，j等于startCell-->datas[0][0]
					// 当i等于startRow，j等于startCell+1-->datas[0][1]
					datas[i - startRow][j - startCell + 1] = cellValue;
				}
				// System.out.println(" ");
			}
			sheet.getRow(startRow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

	/**
	 * 读取excel
	 * 
	 * @param excelPath
	 *            文件路径
	 * @param sheetIndex
	 *            sheet的索引
	 * @param startRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param starCell
	 *            开始列
	 * @param endCell
	 *            结束列
	 * @return 二维数组
	 */
	public static Object[][] readExcel666(String excelPath, int sheetIndex, int startRow, int endRow, int startCell,
			int endCell) {
		// 创建一个二维数组
		// 第2行到第7行 第1列到第4列
		// 1到2有几个数字 2 （2-1）+1=1
		// 2到5有几个数字 4 （5-2）+1=4
		Object[][] datas = new Object[endRow - startRow + 1][endCell - startCell + 1];
		// 1:获得Excel文件输入流(加载资源作为流)
		InputStream is = ExcelUtil.class.getResourceAsStream("/rest_info.xlsx");
		try {
			// 2:获得工作簿--面向接口编程
			Workbook workbook = WorkbookFactory.create(is);
			// 3:得到工作簿
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 操作sheet
			for (int i = startRow; i <= endRow; i++) {
				// 6:得到每一行
				Row row = sheet.getRow(i - 1);
				// System.out.print("这是第"+i);
				// 7:得到每一行的每一列
				for (int j = startCell; j <= endCell; j++) {
					// 8:得到当前遍历的cell
					Cell cell = row.getCell(j - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					// 9:把所有的列的类型都设置为String类型
					cell.setCellType(CellType.STRING);
					String cellValue = cell.getStringCellValue();
					// 当i等于startRow，j等于startCell-->datas[0][0]
					// 当i等于startRow，j等于startCell+1-->datas[0][1]
					datas[i - startRow][j - startCell] = cellValue;
					//// 第2行到第7行 第1列到第4列--6行4列
					// 第一行：i=1
					// 第1列：data[0][0]
					// 第2列：data[0][1]
					// 第3列：data[0][2]
					// 第4列：data[0][3]
					// 第二行：i=2
					// 第1列：data[1][0]
					// 第2列：data[1][1]
					// 第3列：data[1][2]
					// 第4列：data[1][3]
					// System.out.print("["+cellValue+"]");
				}
				// System.out.println(" ");
			}
			sheet.getRow(startRow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

	/**
	 * 
	 * @param excelPath 文件路径
	 * @param sheetIndex sheet的索引
	 * @param startRow  开始行（excel行号）
	 * @param endRow 结束行
	 * @param startCell  开始列
	 * @param endCell  结束列
	 * @return
	 */
	public static Object[][] readExcel(String excelPath, int sheetIndex, int startRow, int endRow, int startCell,
			int endCell) {
		Object[][] datas = new Object[endRow - startRow + 1][endCell - startCell + 1];
		// 1:获得Excel文件输入流(加载资源作为流)
	//	InputStream is = ExcelUtil.class.getResourceAsStream("/login.xlsx");
		InputStream is = ExcelUtil.class.getResourceAsStream(excelPath);
		try {
			// 2:获得工作簿--面向接口编程
			Workbook workbook = WorkbookFactory.create(is);
			// 3:得到工作簿
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 4：循环所有的行
			for (int i = startRow; i <= endRow; i++) {
				//5：得到每一行
				Row row = sheet.getRow(i - 1);
				//6:循环每一行的每一列
				for (int j = startCell; j <= endCell; j++) {
					//得到当前遍历的cell
					Cell cell = row.getCell(j - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					//把所有列的类型都设置为String类型
					cell.setCellType(CellType.STRING);
					String cellValue = cell.getStringCellValue();
					datas[i - startRow][j - startCell] = cellValue;
				}
			}
			sheet.getRow(startRow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

	/**
	 * 读取excel所有信息
	 * 
	 * @param excelPath
	 * @param sheetIndex
	 */
	public static void readExcelAllData(String excelPath, int sheetIndex) {
		// 1:获得Excel文件输入流(加载资源作为流)
		InputStream is = ExcelUtil.class.getResourceAsStream(excelPath);
		XSSFWorkbook workbook = null;
		try {
			// 2:获得工作簿
			workbook = new XSSFWorkbook(is);
			// 3:得到sheet
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			// 得到最大行数
			int lastRowNum = sheet.getLastRowNum();
			// 4:循环所有的行
			// System.out.println(lastRowNum);
			for (int i = 0; i <= lastRowNum; i++) {
				// 得到每一行
				XSSFRow row = sheet.getRow(i);
				// 得到当前行的最大列号
				int LastCellNum = row.getLastCellNum();
				// 遍历每行的所有的列
				for (int j = 0; j < LastCellNum; j++) {
					XSSFCell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String cellValue = cell.getStringCellValue();
					System.out.print("[" + cellValue + "] -");
				}
				System.out.println(" ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 写入结果到某个excel的某一列
	 * 
	 * @param filePath
	 *            excel的路径
	 * @param sheetIndex
	 *            sheet的索引
	 * @param caseId
	 *            测试用例的id,通过这个id可以匹配到某一行
	 * @param cellNum
	 *            列号，明确要写的cell
	 * @param resultStr
	 *            回写的结果
	 */
	@Deprecated
	public static void writeExcel(String filePath, int sheetIndex, String caseId, int cellNum, String resultStr) {
		// poi
		InputStream is = ExcelUtil.class.getResourceAsStream(filePath);
		Workbook workbook = null;
		OutputStream stream = null;
		try {
			// 创建workbook对象
			workbook = WorkbookFactory.create(is);
			// 获得要操作sheet
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 确定哪一行，遍历每一行，如果这行的第一列的值等于caseId,这就是我要执行的行
			// 得到最大的行数
			int lastRowNum = sheet.getLastRowNum();
			// 4:循环所有的行
			for (int i = 0; i < lastRowNum; i++) {
				// 拿到当前行
				Row row = sheet.getRow(i);
				// 拿到该行的第一列
				Cell cell = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellType(CellType.STRING);
				// 得到该列的值
				String cellValue = cell.getStringCellValue();
				// 找到了该行
				if (cellValue.equals(caseId)) {
					// 在该行的cellNum列写入回写结果
					// 需要写数据的cell
					Cell cellToBeWrite = row.getCell(cellNum - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cellToBeWrite.setCellType(CellType.STRING);
					// 设置该行的数据
					cellToBeWrite.setCellValue(resultStr);
					// 已经找到此行，跳出整个循环
					break;
				}
			}
			stream = new FileOutputStream(new File("target/test-classes/rest_info.xlsx"));// 相当于我们类路径
			workbook.write(stream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 工具类中，通常写一个main-->方便测试，提供列子给其他用
	public static void main(String[] args) {
		// Object[][] datas = readExcel("/rest_info.xlsx", 0, 2, 7, 1, 8);
		/*
		 * Object[][] datas = readExcel("/rest_info.xlsx", 1, 2, 12, 1, 4);
		 * //Object[][] datas = readExcel("target/test-classes/rest_info.xlsx",
		 * 1, 2, 12, 1, 4); 
		 * for (Object[] objects : datas) 
		 * { for (Object object
		 * : objects)
		 *  { System.out.print("[" + object + "]"); }
		 * System.out.println(" "); } // readExcelAllData("/rest_info.xlsx", 0);
		 * //readExcel("target/test-classes/rest_info.xlsx", 1, 2, 12, 1, 4);
		 * //writeExcel("/rest_info.xlsx", 1, "1", 5,"are you ?");
		 * //batchWriteData("/rest_info.xlsx",
		 * "target/test-classes/rest_info.xlsx",1);
		 */
		
		//read("/rest_info.xlsx", 0, ApiInfo.class);
		//read("/NB-deviceID.xlsx", 0, CryExcelInfo.class);
		
		//readExcelAllData("/login.xlsx", 0);
		Object[][] datas = readExcel("/login.xlsx", 0, 2, 6, 1, 4);
		for (Object[] objects : datas) {
			for (Object object2 : objects) {
				System.out.print("[" + object2 + "]");
			}
			System.out.println();
		}
	}
	

	/**
	 * 批量写回数据
	 * 
	 * @param sourcePath
	 *            源文件路径
	 * @param targetPath
	 *            目标路径
	 * @param sheetIndex
	 *            sheet索引
	 */
	public static void batchWriteData(String sourcePath, String targetPath, int sheetIndex) {
		Workbook workbook = null;
		InputStream is = ExcelUtil.class.getResourceAsStream(sourcePath);
		OutputStream stream = null;
		try {
			// 创建workbook对象
			workbook = WorkbookFactory.create(is);
			// 获得要操作sheet
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 怎么去写：static List<CellData> dataToWritelist
			// 得到最大的行数
			// int lastRowNum=sheet.getLastRowNum();
			// 获得这个apiParams的所有信息
			Map<String, ApiParams> apiParamsMap = ApiParamUtil.getApiParamsMap();
			for (CellData cellData : dataToWriteList) {
				
				// cellData：这个是要往某一行某一列写入某数据的对象
				// 得到当前行的apiParams
				ApiParams apiParams = apiParamsMap.get(cellData.getCaseId());
				// 得到要写的行号
				int rowNum = apiParams.getRowNum();
				// 拿到当前行
				Row row = sheet.getRow(rowNum - 1);
				// 需要写数据的cell
				Cell cellToBeWrite = row.getCell(cellData.getCellNum() - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cellToBeWrite.setCellType(CellType.STRING);
				// 设置该行的数据
				cellToBeWrite.setCellValue(cellData.getResultStr());
			}
			stream = new FileOutputStream(new File(targetPath));// 相当于我们类路径
			workbook.write(stream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 读取execl的一个sheet-->数据保存到哪？-->面向对象编程思想-->描述共性，抽象-->类
	 * -->模板-->创建对应的java对象
	 * 
	 * @param excelPath
	 * @param sheetIndex
	 * @param clazz
	 */
	public static List<? extends ExcelRowObject> read(String excelPath, int sheetIndex, Class<? extends ExcelRowObject> clazz) {
		// 1:获得Excel文件输入流(加载资源作为流)"/rest_info.xlsx"
		InputStream is = ExcelUtil.class.getResourceAsStream(excelPath);
		List<ExcelRowObject> rowObjectList=new ArrayList<ExcelRowObject>();
		try {
			// 2:获得工作簿--面向接口编程
			Workbook workbook = WorkbookFactory.create(is);
			// 3:得到工作簿
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 怎么包装成对象
			// sheet1-->ApiInfo对象
			// sheet2-->ApiParams对象
			// 1：第一行是相当于该对象的各个属性名，只有得到这一行
			Row firstRow = sheet.getRow(0);
			// 得到最大的列号
			int lastCellNum = firstRow.getLastCellNum();
			// 遍历第一行的每一列
			// 保存属性--容器？？
			String[] filedArray = new String[lastCellNum];

			for (int i = 0; i < lastCellNum; i++) {
				Cell cell = firstRow.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellType(CellType.STRING);
				// 得到每列的值
				String cellValue = cell.getStringCellValue();
				// System.out.print(cellValue);
//				filedArray[i] = cellValue.substring(0, cellValue.indexOf("("));
				filedArray[i] = cellValue.substring(0);
				System.out.println(filedArray[i] + "，");
			}
			// 2：除了第一行：ApiInfo对象 、ApiParams对象，遍历除了第一行的其他所有行
			// 首先要得到最大的行号
			
			int lastRowNum = sheet.getLastRowNum();
			// ApiInfo apiInfo=new ApiInfo();
			
			for (int i = 1; i <= lastRowNum; i++) {// i:表示行的索引
				// 得到了除了第一行的每一行--》apiInfo和apiparams或者其他sheet对应的对象
				//Object object = clazz.newInstance();
				//父类类型接收子类对象：多态
				ExcelRowObject object = clazz.newInstance();

				String setNumMethodStr="setRowNum";
				Method setNumMethod=clazz.getMethod(setNumMethodStr, int.class);
				setNumMethod.invoke(object, i+1);
				
				Row row = sheet.getRow(i);

				// 遍历每一列
				for (int j = 0; j < lastCellNum; j++) {
					Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					// 得到每列的值
					String cellValue = cell.getStringCellValue();
					System.out.print(cellValue + ",");
					// 把这每列的值设值到这个对象中
					// TODO
					// 属性从哪里来？属性的名称从哪里来--》从上面的filedArray中获取
					String filedName = filedArray[j];
					// 得到setter
					String setter = "set" + filedName;
					// 获得这个方法
					Method seeterMethod = clazz.getMethod(setter, String.class);
					
					//正则匹配然后替换为全局的数据，得到需要的字符串
					String commonStr=ParamUtil.getCommonStr(cellValue);
					
					// 反射调用这个setter方法，完成属性的设值
					seeterMethod.invoke(object, commonStr);
				}
				
				rowObjectList.add(object);
				System.out.println();
				// ApiInfo--》ApiInfo列表--》容器-->全局
				// ApiParams--》ApiParams列表--》容器
				// 如果说传入的类型是apiInfo的话
				/*
				if (object instanceof ApiInfo) {
					ApiInfo apiInfo = (ApiInfo) object;
				//	ApiInfoConfig.apiInfoList.add(apiInfo);
					ApiInfoConfig.getApiInfoList().add(apiInfo);
				}
				else if (object instanceof ApiParams) {
					ApiParams apiParams=(ApiParams) object;
					//ApiParamsConfig.apiParamsList.add(apiParams);
					ApiParamsConfig.getApiParamsList().add(apiParams);
				}
				*/
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowObjectList;
	}

	/**
	 * 批量写回
	 * 
	 * @param sourcePath
	 *            源文件路径
	 * @param targetPath
	 *            目标路径
	 * @param sheetIndex
	 *            sheet索引
	 */
	public static void batchWriteData1(String sourcePath, String targetPath, int sheetIndex) {
		// TODO Auto-generated method stub
		// poi
		Workbook workbook = null;
		InputStream is = ExcelUtil.class.getResourceAsStream(sourcePath);
		OutputStream stream = null;
		try {
			// 创建workbook对象
			workbook = WorkbookFactory.create(is);
			// 获得要操作sheet
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			// 怎么去写：static List<CellData> dataToWritelist
			// 得到最大的行数
			int lastRowNum = sheet.getLastRowNum();
			// 获得这个api的所有信息
			// Map<String, ApiInfo> apiInfoMap=ApiUtil.getApiInfoMap();
			Map<String, ApiParams> apiParamsMap = ApiParamUtil.getApiParamsMap();
			for (CellData cellData : dataToWriteList) {
				// cellData：这个是要往某一行某一列写入某数据的对象
				// 得到当前行的ApiInfo
				ApiParams apiParams = apiParamsMap.get(cellData.getCaseId());
				// 得到要写的行号
				int rowNum = apiParams.getRowNum();
				// 通过一个caseId来找到行号--
				for (int i = 0; i < lastRowNum; i++) {
					// 拿到当前行
					Row row = sheet.getRow(i);
					// 拿到该行的第一列
					Cell cell = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					// 得到该列的值:第一列的值
					String cellValue = cell.getStringCellValue();
					// 找到了该行
					if (cellValue.equals(cellData.getCaseId())) {
						// 在该行的cellNum列写入回写结果
						// 需要写数据的cell
						Cell cellToBeWrite = row.getCell(cellData.getCellNum() - 1,
								MissingCellPolicy.CREATE_NULL_AS_BLANK);
						cellToBeWrite.setCellType(CellType.STRING);
						// 设置该行的数据
						cellToBeWrite.setCellValue(cellData.getResultStr());
						// 已经找到此行，跳出整个循环
						break;
					}
				}
			}
			stream = new FileOutputStream(new File(targetPath));// 相当于我们类路径
			workbook.write(stream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}