package com.moe.udise.api.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moe.udise.api.util.NativeRepository;
import com.moe.udise.api.util.QueryResult;
import com.moe.udise.api.util.StaticReportBean;
import com.moe.udise.api.util.UdiseResponse;

@Service
public class FlashStaticSchoolImplementation {
	@Autowired
	NativeRepository nativeRepository;

	public UdiseResponse getNumberOfSchool(Map<Object, Object> input) {

		QueryResult qrObj = null;
		StaticReportBean sobj = new StaticReportBean();
		UdiseResponse responseObj = new UdiseResponse();

		String management_id = null;
		String management_name = null;
		String management_value=null;

		String category_id = null;
		String category_name = null;
		String category_value = null;
		String year_id=String.valueOf(input.get("yearId"));
		String query="";
		
		try {
			management_value=String.valueOf(input.get("managementValue"));
			category_value=String.valueOf(input.get("categoryValue"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		try {

			if (String.valueOf(input.get("managementType")).equalsIgnoreCase("4")) {
				management_id = "broad_mgmt_id";
				management_name = "broad_mgmt_name";
			} else if (String.valueOf(input.get("managementType")).equalsIgnoreCase("17")) {
				management_id = "sch_mgmt_id";
				management_name = "sch_mgmt_name";
			}

			if (String.valueOf(input.get("categoryType")).equalsIgnoreCase("4")) {
				category_id = "broad_category_id";
				category_name = "broad_category_name";
			} else if (String.valueOf(input.get("categoryType")).equalsIgnoreCase("10")) {
				category_id = "sch_category_id";
				category_name = "sch_category_name";
			}
			
			
			query="select sum(no_of_school) as no_of_school , "+management_id+","+management_name+","+category_id+","+category_name+", state_code ,state_name ,year_id from flash_statisticts.api_school where year_id ="+year_id+" and "+management_id+"="+management_value+" and "+category_id+"= "+category_value+"   group by "+management_id+","+management_name+","+category_id+","+category_name+" ,state_code ,state_name ,year_id ";
			
			if(management_value.equalsIgnoreCase("99") && !category_value.equalsIgnoreCase("99")  && !category_value.equalsIgnoreCase("100")) {
				query="select sum(no_of_school) as no_of_school , "+management_id+","+management_name+","+category_id+","+category_name+", state_code ,state_name ,year_id from flash_statisticts.api_school where year_id ="+year_id+"  and "+category_id+"= "+category_value+"   group by "+management_id+","+management_name+","+category_id+","+category_name+" ,state_code ,state_name ,year_id ";	
			}
			else if(management_value.equalsIgnoreCase("99") && category_value.equalsIgnoreCase("99")) {
				query="select sum(no_of_school) as no_of_school , "+management_id+","+management_name+","+category_id+","+category_name+", state_code ,state_name ,year_id from flash_statisticts.api_school where year_id ="+year_id+"   group by "+management_id+","+management_name+","+category_id+","+category_name+" ,state_code ,state_name ,year_id ";	
			}else if(management_value.equalsIgnoreCase("99") && category_value.equalsIgnoreCase("100")) {
				query="select sum(no_of_school) as no_of_school , "+management_id+","+management_name+","+category_id+" all ,"+category_name+" all , state_code ,state_name ,year_id from flash_statisticts.api_school where year_id ="+year_id+" group by "+management_id+","+management_name+" ,state_code ,state_name ,year_id ";
			}else if(category_value.equalsIgnoreCase("99") && !management_value.equalsIgnoreCase("99")  && !management_value.equalsIgnoreCase("100")) {
				query="select sum(no_of_school) as no_of_school , "+management_id+","+management_name+","+category_id+","+category_name+", state_code ,state_name ,year_id from flash_statisticts.api_school where year_id ="+year_id+"  and "+management_id+"= "+management_value+"   group by "+management_id+","+management_name+","+category_id+","+category_name+" ,state_code ,state_name ,year_id ";	
			}
			else if(category_value.equalsIgnoreCase("99") && management_value.equalsIgnoreCase("99")) {
				query="select sum(no_of_school) as no_of_school , "+management_id+","+management_name+","+category_id+","+category_name+", state_code ,state_name ,year_id from flash_statisticts.api_school where year_id ="+year_id+"   group by "+management_id+","+management_name+","+category_id+","+category_name+" ,state_code ,state_name ,year_id ";	
			}else if(category_value.equalsIgnoreCase("99") && management_value.equalsIgnoreCase("100")) {
				query="select sum(no_of_school) as no_of_school , "+category_id+","+category_name+","+management_id+" all ,"+management_name+" all , state_code ,state_name ,year_id from flash_statisticts.api_school where year_id ="+year_id+" group by "+category_id+","+category_name+" ,state_code ,state_name ,year_id ";
			}
			
			
			
			
//			else if(management_value.equalsIgnoreCase("100") && category_value.equalsIgnoreCase("99")) {
//				
//			}else if(management_value.equalsIgnoreCase("100") && category_value.equalsIgnoreCase("100")) {
//				
//			}
			
			
			qrObj = nativeRepository.executeQueries(query);
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
