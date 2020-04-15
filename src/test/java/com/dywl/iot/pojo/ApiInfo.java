package com.dywl.iot.pojo;

/**
 * api基本信息
 * 
 * 用来作为从excel的api基本信息转化成java对象的这样一个载体类型
 * 
 * xml--解析--》Student--》方便我们java操作
 * 
 * @author asus
 *
 */
public class ApiInfo extends ExcelRowObject {
	
	
	
	/**
	 * api编号
	 */
	private String apiId;
	/**
	 * api名称
	 */
	private String apiName;
	/**
	 * 请求类型
	 */
	private String type;
	/**
	 * 请求地址
	 */
	private String url;
	
	/**
	 * 获取api编号
	 * 
	 * @return
	 */
	public String getApiId() {
		return apiId;
	}

	/**
	 * 设置api编号
	 * 
	 * @param apiId
	 */
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	/**
	 * 获取api名称
	 * 
	 * @return
	 */
	public String getApiName() {
		return apiName;
	}

	/**
	 * 设置api名称
	 * 
	 * @param apiName
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	/**
	 * 获取api类型
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置api类型
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取api地址
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置api地址
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ApiInfo [rowNum=" + this.getRowNum() + ", apiId=" + apiId + ", apiName=" + apiName + ", type=" + type + ", url="
				+ url + "]";
	}

}