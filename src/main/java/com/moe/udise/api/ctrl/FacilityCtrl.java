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

import com.moe.udise.api.service.FacilityCtrlImplementation;
import com.moe.udise.api.util.CommonUtilMethod;
import com.moe.udise.api.util.RequestPath;
import com.moe.udise.api.util.UdiseResponse;

@RequestMapping(RequestPath.facilityApi.ctrl)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FacilityCtrl {

	@Autowired
	FacilityCtrlImplementation facilityCtrlImplementation;
	
	
	@RequestMapping(value = "/getFacilityIndicator", method = RequestMethod.POST,consumes =MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<UdiseResponse> getFacilityIndicator(@RequestBody String reqData) {
		Map<Object, Object> requestMap=new CommonUtilMethod().convertStringToMap(reqData);
		return ResponseEntity.ok(facilityCtrlImplementation.getFacilityIndicator(requestMap));
	}
}
