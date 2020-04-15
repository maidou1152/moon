package com.dywl.iot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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


import com.dywl.iot.pojo.CellData;
import com.dywl.iot.pojo.CryExcelInfo;


public class Excel {
	
	
	/**
	 * 收集要写的数据的容器，容器中就是一个一个要写的数据对象CellData
	 */
	public static List<CellData> dataToWriteList = new ArrayList<CellData>();

	

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
	public static Object[][] readExcel(String excelPath, int sheetIndex, int startRow, int endRow, int startCell,
			int endCell) {
		// 创建一个二维数组
		// 第2行到第7行 第1列到第4列
		// 1到2有几个数字 2 （2-1）+1=1
		// 2到5有几个数字 4 （5-2）+1=4
		Object[][] datas = new Object[endRow - startRow + 1][endCell - startCell + 1];
		// 1:获得Excel文件输入流(加载资源作为流)
		//InputStream is = ExcelUtil.class.getResourceAsStream("/NB-deviceID.xlsx");
		InputStream is = ExcelUtil.class.getResourceAsStream(excelPath);
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
				}
			}
			sheet.getRow(startRow);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
		
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
		public static void batchWriteData11(String sourcePath, String targetPath, int sheetIndex) {
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
			//	Map<String, ApiParams> apiParamsMap = ApiParamUtil.getApiParamsMap();
					Map<String, CryExcelInfo> cMap = CryExcelInfoUtil.getCryExcelInfo();
				for (CellData cellData : dataToWriteList) {
					
					// cellData：这个是要往某一行某一列写入某数据的对象
					// 得到当前行的apiParams
					CryExcelInfo cryExcelInfo = cMap.get(cellData.getCaseId());
					// 得到要写的行号
					int rowNum = cryExcelInfo.getRowNum();
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
		 * 批量写回:NB
		 * @param sourcePath 源文件路径
		 * @param targetPath 目标路径
		 * @param sheetIndex sheet索引
		 */
		public static void batchWriteData(String sourcePath,String targetPath,int sheetIndex) {
			Workbook workbook = null;
			InputStream is = ExcelUtil.class.getResourceAsStream(sourcePath);
			OutputStream stream = null;
			try {
					// 创建workbook对象
					workbook = WorkbookFactory.create(is);
					// 获得要操作sheet
					Sheet sheet = workbook.getSheetAt(sheetIndex);
					//怎么去写：static List<CellData> dataToWritelist
					//得到最大的行数
					int lastRowNum=sheet.getLastRowNum();
					for (CellData cellData : dataToWriteList) {
						//cellData：这个是要往某一行某一列写入某数据的对象
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
								Cell cellToBeWrite = row.getCell(cellData.getCellNum() - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
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
						if (workbook != null) 
						{
							try {
								workbook.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (stream!=null) {
							try {
								stream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (is!=null) {
							try {
								is.close();
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
		 *            /web_auto/src/test/resources/NB-deviceID.xlsx
		 */
		public static void writeExcel(String filePath, int sheetIndex, String caseId, int cellNum, String resultStr) {
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
				stream = new FileOutputStream(new File("target/test-classes/NB-deviceID.xlsx"));// 相当于我们类路径
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
		
	
		
		
	public static void main(String[] args) {
		//Object[][] data=readExcel("/NB-deviceID.xlsx", 0, 68, 1000, 4, 4);
		Object[][] data=readExcel("/rtuno.xlsx", 0, 1, 24, 2, 2);
		for (Object[] objects : data) {
			for (Object object : objects) {
				System.out.print("[" + object + "]");
			}
			System.out.println();
		}
		
		
		//ExcelUtil.batchWriteData("/NB-deviceID.xlsx","target/test-classes/NB-deviceID_2019_08_21.xlsx",1);
		//Excel.writeExcel("src/test/resources/NB-deviceID.xlsx", 0, "1", 5, "24422");
		//writeExcel("/NB-deviceID.xlsx", 1, "1", 5,"are you ?");
	}
}