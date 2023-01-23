package com.moe.udise.api.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtilMethod {
	
public Map<Object, Object> convertStringToMap(String data){
	ObjectMapper mapperObj = new ObjectMapper();
	Map<Object,Object>  mObject=new HashMap<Object,Object>();
	try {
		mObject = mapperObj.readValue(data, new TypeReference<HashMap<Object,Object>>() {
		});
	}catch(Exception ex) {
//		LOGGER.warn("--message--",ex);
	}
	return mObject;
	
}
}
