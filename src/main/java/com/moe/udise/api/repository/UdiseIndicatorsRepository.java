package com.moe.udise.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moe.udise.api.modal.UdiseIndicators;

//import com.moe.sdmis.fileservice.modal.StudentBasicProfile;

@Repository
public interface UdiseIndicatorsRepository  extends JpaRepository<UdiseIndicators, Long> {
	
	
//@Query(nativeQuery = true, value = "select * from moe_udise_indicator ut where ut.region_type=:region_type and ut.region_id=:region_id and ut.item_group=:item_group and ut.item_id=:item_id and ut.value_type=:value_type")
//	@Query(nativeQuery = true, value = "select ut from UdiseIndicators ut where ut.regionType= :region_type and ut.regionId=:region_id and ut.itemGroup=:item_group and ut.itemId=:item_id and ut.valueType=:value_type")
// List<UdiseIndicators>  getDropOut(@Param("region_type") String region_type,@Param("region_id") int region_id,@Param("item_group") int item_group, @Param("item_id") int item_id,@Param("value_type") int value_type);

@Query(nativeQuery = true, value = "select * from moe_udise_indicator ut where region_type=:region_type and region_id=:regionId and item_group=:itemGroup and item_id=:itemId and value_type=:valueType")
//	@Query(nativeQuery = true, value = "select ut from UdiseIndicators ut where ut.regionType= :region_type and ut.regionId=:region_id and ut.itemGroup=:item_group and ut.itemId=:item_id and ut.valueType=:value_type")
 List<UdiseIndicators>  getDropOut(String region_type,int regionId,int itemGroup, int itemId,int valueType);
 
}

