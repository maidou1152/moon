package com.dywl.iot.pojo;


public class Page {

	/**
	 * 页面名称
	 */
	private String name;
	/**
	 * 关键字描述
	 */
	private String desc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Page(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Page [name=" + name + ", desc=" + desc + "]";
	}
}
