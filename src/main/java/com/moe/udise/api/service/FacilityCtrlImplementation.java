package com.moe.udise.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

//import com.moe.sdmis.fileservice.db.QueryResult;
//import com.moe.sdmis.fileservice.db.StaticReportBean;
import com.moe.udise.api.util.CommonUtilMethod;
import com.moe.udise.api.util.NativeRepository;
import com.moe.udise.api.util.QueryResult;
import com.moe.udise.api.util.StaticReportBean;
import com.moe.udise.api.util.UdiseResponse;

@Service
public class FacilityCtrlImplementation {

	@Autowired
	NativeRepository nativeRepository;

	public UdiseResponse getFacilityIndicator(Map<Object, Object> requestMap) {
		QueryResult qrObj = null;
		StaticReportBean sobj = new StaticReportBean();
		UdiseResponse responseObj = new UdiseResponse();
		String schema = null;
		if (String.valueOf(requestMap.get("acYear")).equalsIgnoreCase("2021")) {
			schema = "api_2122";
		} else if (String.valueOf(requestMap.get("acYear")).equalsIgnoreCase("2022")) {
			schema = "api_2223";
		} else if (String.valueOf(requestMap.get("acYear")).equalsIgnoreCase("2020")) {
			schema = "api_2021";
		}
		try {
			if (String.valueOf(requestMap.get("regionType")).equalsIgnoreCase("AD")) {
				qrObj = nativeRepository.executeQueries(
						"select id, region_type, parent_region_type, item_group_id, item_group_name, item_id, item_name, value_type, item_numerator1_description,item_numerator2_description, item_denominator_description, d1.data_json ->> 'parent_region_code' as parent_region_code, d1.data_json ->> 'parent_region_name' as parent_region_name, d1.data_json ->> 'region_code' as region_code, d1.data_json ->> 'region_name' as region_name,d1.data_json ->> 'item_numerator1' as item_numerator1,d1.data_json ->> 'item_numerator2' as item_numerator2, d1.data_json ->> 'item_denominator' as item_denominator from (SELECT *, json_array_elements(district_info) as data_json FROM "
								+ schema + ".district_info_01 where item_group_id = '" + requestMap.get("itemGroup")
								+ "' and item_id = '" + requestMap.get("itemId")
								+ "' ) d1 where  CAST (d1.data_json ->> 'parent_region_code' as numeric) ="
								+ requestMap.get("regionCode"));
			} else if (String.valueOf(requestMap.get("regionType")).equalsIgnoreCase("D")) {
				qrObj = nativeRepository.executeQueries(
						"select id, region_type, parent_region_type, item_group_id, item_group_name, item_id, item_name, value_type, item_numerator1_description,item_numerator2_description, item_denominator_description, d1.data_json ->> 'parent_region_code' as parent_region_code, d1.data_json ->> 'parent_region_name' as parent_region_name, d1.data_json ->> 'region_code' as region_code, d1.data_json ->> 'region_name' as region_name, d1.data_json ->> 'item_numerator1' as item_numerator1,d1.data_json ->> 'item_numerator2' as item_numerator2, d1.data_json ->> 'item_denominator' as item_denominator from (SELECT *, json_array_elements(district_info) as data_json FROM "
								+ schema + ".district_info_01 where item_group_id = '" + requestMap.get("itemGroup")
								+ "' and item_id = '" + requestMap.get("itemId")
								+ "' ) d1 where  CAST (d1.data_json ->> 'region_code' as numeric) ="
								+ requestMap.get("regionCode"));
			} else if (String.valueOf(requestMap.get("regionType")).equalsIgnoreCase("S")) {
				qrObj = nativeRepository.executeQueries(
						"select id, region_type, parent_region_type, item_group_id, item_group_name, item_id, item_name, value_type, item_numerator1_description,item_numerator2_description, item_denominator_description, d1.data_json ->> 'parent_region_code' as parent_region_code, d1.data_json ->> 'parent_region_name' as parent_region_name, d1.data_json ->> 'region_code' as region_code, d1.data_json ->> 'region_name' as region_name, d1.data_json ->> 'item_numerator1' as item_numerator1,d1.data_json ->> 'item_numerator2' as item_numerator2, d1.data_json ->> 'item_denominator' as item_denominator from (SELECT *, json_array_elements(state_info) as data_json FROM "
								+ schema + ".state_info_01 where item_group_id = '" + requestMap.get("itemGroup")
								+ "' and item_id = '" + requestMap.get("itemId")
								+ "' ) d1 where  CAST (d1.data_json ->> 'region_code' as numeric) ="
								+ requestMap.get("regionCode"));
			}
			responseObj.setStatus(1);
			responseObj.setResData(qrObj.getRowValue());
			responseObj.setMessage("success");
		} catch (Exception e) {
			responseObj.setStatus(0);
			responseObj.setMessage("success");
			e.printStackTrace();
		}
		return responseObj;
	}

}
