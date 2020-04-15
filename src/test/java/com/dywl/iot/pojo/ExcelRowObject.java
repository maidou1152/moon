package com.dywl.iot.pojo;

/**
 * 接口/抽象类？
 * 抽象类：模板设计思想（任何sheet进行描述的时候，都要继承我）--避免子类设计的随意性
 * 接口：服务、能力
 * @author asus
 *
 */
public class ExcelRowObject {


	/**
	 * 行号（execl）
	 */
	private int rowNum;

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
}
