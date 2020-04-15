package com.dywl.iot.pojo;

/**
 * 在哪行哪列要写的数据
 * 任何一行的任何一列要写入的数据
 * @author asus
 *
 */
public class CellData {
	//行、列、数据
	/**
	 * 测试用例编号
	 */
	private String caseId;
	/**
	 * 列号
	 */
	private int cellNum;
	/**
	 * 要写的数据
	 */
	private String resultStr;
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public int getCellNum() {
		return cellNum;
	}
	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}
	public String getResultStr() {
		return resultStr;
	}
	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	public CellData(String caseId, int cellNum, String resultStr) {
		super();
		this.caseId = caseId;
		this.cellNum = cellNum;
		this.resultStr = resultStr;
	}
	@Override
	public String toString() {
		return "CellData [caseId=" + caseId + ", cellNum=" + cellNum + ", resultStr=" + resultStr + "]";
	}
}