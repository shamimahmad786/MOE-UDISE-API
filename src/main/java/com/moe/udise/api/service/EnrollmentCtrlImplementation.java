package com.moe.udise.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moe.udise.api.repository.EnrollmentDt01Repository;
import com.moe.udise.api.repository.EnrollmentSt01Repository;
import com.moe.udise.api.util.UdiseResponse;

@Service
public class EnrollmentCtrlImplementation {
	@Autowired
	EnrollmentSt01Repository enrollmentSt01Repository;

	@Autowired
	EnrollmentDt01Repository enrollmentDt01Repository;

	ObjectMapper mapper = new ObjectMapper();

	public UdiseResponse getEnrollmentIndicator(Map<Object, Object> mp) {

		List<Map<String, Object>> finalRes = new ArrayList<Map<String, Object>>();
		UdiseResponse re = new UdiseResponse();
		try {
//			System.out.println((String.valueOf(mp.get("regionType"))));
//			System.out.println( Integer.parseInt(String.valueOf(mp.get("itemGroup"))));
//			System.out.println((int) mp.get("valueType"));
			System.out.println(Integer.parseInt(String.valueOf(mp.get("itemGroup"))));
			System.out.println(String.valueOf(mp.get("regionType")));
			List<?> lt = null;
//			EnrollmentSt01
//			if (Integer.parseInt(String.valueOf(mp.get("itemGroup"))) == 422 && String.valueOf(mp.get("regionType")).equalsIgnoreCase("S")) {
			if(String.valueOf(mp.get("acYear")).equalsIgnoreCase("2021")) {
			if (String.valueOf(mp.get("regionType")).equalsIgnoreCase("S")) {
				lt = enrollmentSt01Repository.getEnrollmentData2122(String.valueOf(mp.get("regionType")),
						String.valueOf(mp.get("regionCode")), Integer.parseInt(String.valueOf(mp.get("itemGroup"))),
						Integer.parseInt(String.valueOf(mp.get("itemId"))),
						Integer.parseInt(String.valueOf(mp.get("valueType"))));
			} else if (String.valueOf(mp.get("regionType")).equalsIgnoreCase("AD")) {
				 
				lt = enrollmentDt01Repository.findAllByParentRegionCodeAndRegionTypeAndItemGroupIdAndItemIdAndValueType2122(
						String.valueOf(mp.get("regionCode")), "D",
						Integer.parseInt(String.valueOf(mp.get("itemGroup"))),
						Integer.parseInt(String.valueOf(mp.get("itemId"))),
						Integer.parseInt(String.valueOf(mp.get("valueType"))));
			} else if (String.valueOf(mp.get("regionType")).equalsIgnoreCase("D")) {
				lt = enrollmentDt01Repository.findAllByRegionCodeAndRegionTypeAndItemGroupIdAndItemIdAndValueType2122(
						String.valueOf(mp.get("regionCode")), "D",
						Integer.parseInt(String.valueOf(mp.get("itemGroup"))),
						Integer.parseInt(String.valueOf(mp.get("itemId"))),
						Integer.parseInt(String.valueOf(mp.get("valueType"))));
			}
			}
			
			
			lt.stream().forEach(e -> {
				Map<String, Object> map = mapper.convertValue(e, new TypeReference<Map<String, Object>>() {
				});
				map.values().removeIf(Objects::isNull);
				finalRes.add(map);
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Convert POJO to Map

		try {

			re.setResData(finalRes);
			re.setStatus(1);
		} catch (Exception e) {
			re.setStatus(0);
			e.printStackTrace();
		}
		return re;
	}
}
