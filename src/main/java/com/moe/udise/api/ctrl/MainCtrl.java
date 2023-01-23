package com.moe.udise.api.ctrl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moe.udise.api.service.MainCtrlmplementation;
import com.moe.udise.api.util.CommonUtilMethod;
import com.moe.udise.api.util.RequestPath;
import com.moe.udise.api.util.UdiseResponse;

@RequestMapping(RequestPath.udiseApi.ctrl)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MainCtrl {
	
	@Autowired
	MainCtrlmplementation   mainCtrlmplementation;


	@RequestMapping(value = "/getRetentionRate", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<UdiseResponse> getRetentionRate(@RequestBody String reqData) {
		Map<Object, Object> requestMap=new CommonUtilMethod().convertStringToMap(reqData);
		System.out.println(requestMap);
		
		return ResponseEntity.ok(null);
		
	}
	
	
	@RequestMapping(value = "/getIndicator", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<UdiseResponse> getIndicator(@RequestBody String reqData) {
		Map<Object, Object> requestMap=new CommonUtilMethod().convertStringToMap(reqData);
		System.out.println(requestMap);
		return ResponseEntity.ok(mainCtrlmplementation.getIndicator(requestMap));
	}
	
	
	@RequestMapping(value = "/getInfrastructure", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<UdiseResponse> getInfrastructure(@RequestBody String reqData) {
		Map<Object, Object> requestMap=new CommonUtilMethod().convertStringToMap(reqData);
		System.out.println(requestMap);
		
		return ResponseEntity.ok(mainCtrlmplementation.getInfrastructure(requestMap));
	}
	
	
}
