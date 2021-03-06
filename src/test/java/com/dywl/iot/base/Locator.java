package com.dywl.iot.base;


public class Locator {
	/**
	 * 元素定位的方式
	 */
	private String by;
	/**
	 * 元素定位的值
	 */
	private String value;
	/**
	 * 关键字描述
	 */
	private String desc;
	
	/**
	 * 构造函数
	 * @param by
	 * @param value
	 * @param desc
	 */
	public Locator(String by, String value, String desc) {
		super();
		this.by = by;
		this.value = value;
		this.desc = desc;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Locator [by=" + by + ", value=" + value + ", desc=" + desc + "]";
	}
}
