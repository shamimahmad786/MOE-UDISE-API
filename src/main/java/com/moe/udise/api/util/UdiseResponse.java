package com.moe.udise.api.util;

import java.util.List;
import java.util.Map;

public class UdiseResponse {

	
private Integer status;
private String message;
private List<Map<String,Object>> resData;


public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<Map<String, Object>> getResData() {
	return resData;
}
public void setResData(List<Map<String, Object>> resData) {
	this.resData = resData;
}







}
