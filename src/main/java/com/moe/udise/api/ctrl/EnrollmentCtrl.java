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

import com.moe.udise.api.service.EnrollmentCtrlImplementation;
import com.moe.udise.api.util.CommonUtilMethod;
import com.moe.udise.api.util.RequestPath;
import com.moe.udise.api.util.UdiseResponse;

@RequestMapping(RequestPath.enrolApi.ctrl)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EnrollmentCtrl {

	@Autowired
	EnrollmentCtrlImplementation enrollmentCtrlImplementation;
	
	@RequestMapping(value = "/getEnrollmentIndicator", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<UdiseResponse> getEnrollmentIndicator(@RequestBody String reqData) {
		System.out.println("In get enrollment");
		Map<Object, Object> requestMap=new CommonUtilMethod().convertStringToMap(reqData);
		System.out.println(requestMap);
		return ResponseEntity.ok(enrollmentCtrlImplementation.getEnrollmentIndicator(requestMap));
	}
}
