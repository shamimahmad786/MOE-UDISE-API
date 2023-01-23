package com.moe.udise.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moe.udise.api.modal.EnrollmentDt01;
import com.moe.udise.api.modal.EnrollmentSt01;

public interface EnrollmentDt01Repository extends JpaRepository<EnrollmentDt01, Long>{
	@Query(nativeQuery = true, value = "select * from api_2122.enrollment_dt_01 ut where parent_region_code=:regionCode and region_type=:regionType and item_group_id=:itemGroup and item_id=:itemId and value_type=:valueType")
    List<EnrollmentDt01> findAllByParentRegionCodeAndRegionTypeAndItemGroupIdAndItemIdAndValueType2122(	String regionCode, String regionType,
    		Integer itemGroup,
    		Integer itemId,
    		Integer valueType);
	@Query(nativeQuery = true, value = "select * from api_2122.enrollment_dt_01 ut where region_code=:regionCode and region_type=:regionType and item_group_id=:itemGroup and item_id=:itemId and value_type=:valueType")
	List<EnrollmentDt01> findAllByRegionCodeAndRegionTypeAndItemGroupIdAndItemIdAndValueType2122(String regionCode, String regionType,
			Integer itemGroup,
			Integer itemId,
			Integer valueType);
}
