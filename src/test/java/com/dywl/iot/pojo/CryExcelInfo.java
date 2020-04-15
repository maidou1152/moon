package com.dywl.iot.pojo;

public class CryExcelInfo extends ExcelRowObject {
	/**
	 * deviceID编号
	 */
	private String deviceID;
	/**
	 * api名称
	 */
	private String login;
	/**
	 * 请求类型
	 */
	private String sn;
	/**
	 * 请求地址
	 */
	private String code;
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "CryExcelInfo [deviceID=" + deviceID + ", login=" + login + ", sn=" + sn + ", code=" + code + "]";
	}
	
}
