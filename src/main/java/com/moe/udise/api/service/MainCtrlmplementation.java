package com.moe.udise.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moe.udise.api.modal.EnrollmentSt01;
import com.moe.udise.api.modal.UdiseIndicators;
import com.moe.udise.api.modal.UdiseInfrastructure;
import com.moe.udise.api.repository.EnrollmentDt01Repository;
import com.moe.udise.api.repository.EnrollmentSt01Repository;
import com.moe.udise.api.repository.UdiseIndicatorsRepository;
import com.moe.udise.api.repository.UdiseInfrastructureRepository;
import com.moe.udise.api.util.UdiseResponse;

@Service
public class MainCtrlmplementation {

	@Autowired	
	UdiseIndicatorsRepository   udiseIndicatorsRepository;
	@Autowired
	UdiseInfrastructureRepository  udiseInfrastructureRepository;
	

	
	
	ObjectMapper mapper = new ObjectMapper();
	
	public UdiseResponse getIndicator(Map<Object,Object> mp) {
		
	List<Map<String,Object>> finalRes=new ArrayList<Map<String,Object>>();
	UdiseResponse  re=new UdiseResponse();
		try {
//		List<UdiseIndicators>  lt=	udiseIndicatorsRepository.findAll();
			System.out.println((String.valueOf(mp.get("regionType"))));
			System.out.println((int)mp.get("regionId"));
			System.out.println((int)mp.get("valueType"));
//		List<UdiseIndicators>  lt=	udiseIndicatorsRepository.getDropOut(String.valueOf(mp.get("regionType")),(int)mp.get("regionId"),(int)mp.get("itemGroup"),(int)mp.get("itemId"),(int)mp.get("valueType"));
			List<?>  lt=null;
			if((int)mp.get("itemGroup")==423 && String.valueOf(mp.get("regionType")).equalsIgnoreCase("D")) {
				//4 - enrollment
//				lt=enrollmentSt01Repository.getEnrollmentData(String.valueOf(mp.get("regionType")),(int)mp.get("regionId"),(int)mp.get("itemGroup"),(int)mp.get("itemId"),(int)mp.get("valueType"));
			}
			
//			List<UdiseIndicators>  lt=	udiseIndicatorsRepository.getDropOut(String.valueOf(mp.get("regionType")),(int)mp.get("regionId"),(int)mp.get("itemGroup"),(int)mp.get("itemId"),(int)mp.get("valueType"));

		lt.stream().forEach(e->{
			Map<String, Object> map = 
				    mapper.convertValue(e, new TypeReference<Map<String, Object>>() {});
			finalRes.add(map);
		});
		}catch(Exception ex) {
		ex.printStackTrace();	
		}

		// Convert POJO to Map
	
		try {
		
		re.setResData(finalRes);
		re.setStatus(1);
		}catch(Exception e) {
			re.setStatus(0);
			e.printStackTrace();
		}
		return re;
	}
	
	public UdiseResponse getInfrastructure(Map<Object,Object> mp) {
		List<Map<String,Object>> finalRes=new ArrayList<Map<String,Object>>();
		UdiseResponse  re=new UdiseResponse();
			try {
//			List<UdiseIndicators>  lt=	udiseIndicatorsRepository.findAll();
				System.out.println((String.valueOf(mp.get("regionType"))));
				System.out.println((int)mp.get("regionId"));
				System.out.println((int)mp.get("valueType"));
//			List<UdiseIndicators>  lt=	udiseIndicatorsRepository.getDropOut(String.valueOf(mp.get("regionType")),(int)mp.get("regionId"),(int)mp.get("itemGroup"),(int)mp.get("itemId"),(int)mp.get("valueType"));

				List<UdiseInfrastructure>  lt=	udiseInfrastructureRepository.getInfrastucture(String.valueOf(mp.get("regionType")),(int)mp.get("regionId"),(int)mp.get("itemGroup"),(int)mp.get("itemId"),(int)mp.get("valueType"));

			lt.stream().forEach(e->{
				Map<String, Object> map = 
					    mapper.convertValue(e, new TypeReference<Map<String, Object>>() {});
				finalRes.add(map);
			});
			}catch(Exception ex) {
			ex.printStackTrace();	
			}

			// Convert POJO to Map
		
			try {
			
			re.setResData(finalRes);
			re.setStatus(1);
			}catch(Exception e) {
				re.setStatus(0);
				e.printStackTrace();
			}
			return re;
	}
}
