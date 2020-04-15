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
public class ApiParams extends ExcelRowObject {

	
	/**
	 * 测试用例编号
	 */
	private String caseId;
	/**
	 * api编号
	 */
	private String apiId;
	/**
	 * 请求参数
	 */

	private String requestData;
	/**
	 * 期望响应数据
	 */
	private String expectedReponseData;
	
	/**
	 * (实际响应数据)
	 */
	private String actualResponseData;
	
	/**
	 * (接口执行前的脚本验证)
	 */
	private String preValidateSql;
	
	/**
	 * (接口执行前数据库验证结果)
	 */
	private String preValidateResult;
	/**
	 * (接口执行后的脚本验证)
	 */
	private String afterValidateSql;
	/**
	 * (接口执行后数据库验证结果)
	 */
	private String afterValidateResult;
	
	public String getPreValidateSql() {
		return preValidateSql;
	}
	public void setPreValidateSql(String preValidateSql) {
		this.preValidateSql = preValidateSql;
	}


	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getApiId() {
		return apiId;
	}
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}
	public String getRequestData() {
		return requestData;
	}
	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}
	public String getExpectedReponseData() {
		return expectedReponseData;
	}
	public void setExpectedReponseData(String expectedReponseData) {
		this.expectedReponseData = expectedReponseData;
	}
	public String getActualResponseData() {
		return actualResponseData;
	}
	public void setActualResponseData(String actualResponseData) {
		this.actualResponseData = actualResponseData;
	}

	public String getPreValidateResult() {
		return preValidateResult;
	}
	public void setPreValidateResult(String preValidateResult) {
		this.preValidateResult = preValidateResult;
	}
	public String getAfterValidateSql() {
		return afterValidateSql;
	}
	public void setAfterValidateSql(String afterValidateSql) {
		this.afterValidateSql = afterValidateSql;
	}
	public String getAfterValidateResult() {
		return afterValidateResult;
	}
	public void setAfterValidateResult(String afterValidateResult) {
		this.afterValidateResult = afterValidateResult;
	}
	
	@Override
	public String toString() {
		return "ApiParams [rowNum=" + this.getRowNum()+ ", caseId=" + caseId + ", apiId=" + apiId + ", requestData="
				+ requestData + ", expectedReponseData=" + expectedReponseData + ", actualResponseData="
				+ actualResponseData + ", preValidateSql=" + preValidateSql + ", preValidateResult=" + preValidateResult
				+ ", afterValidateSql=" + afterValidateSql + ", afterValidateResult=" + afterValidateResult + "]";
	}

}