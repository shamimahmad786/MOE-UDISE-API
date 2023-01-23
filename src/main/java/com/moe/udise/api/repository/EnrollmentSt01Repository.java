package com.moe.udise.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moe.udise.api.modal.EnrollmentSt01;
import com.moe.udise.api.modal.UdiseIndicators;

public interface EnrollmentSt01Repository extends JpaRepository<EnrollmentSt01, Long>{
  @Query(nativeQuery = true, value = "select * from api_2122.enrollment_st_01 ut where region_type=:region_type and region_code=:regionCode and item_group_id=:itemGroup and item_id=:itemId and value_type=:valueType")
  List<EnrollmentSt01>	getEnrollmentData2122(String region_type,String regionCode,int itemGroup, int itemId,int valueType);
  
  

//  List<EnrollmentSt01>  
}
