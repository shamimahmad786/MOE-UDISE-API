package com.moe.udise.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moe.udise.api.modal.UdiseIndicators;
import com.moe.udise.api.modal.UdiseInfrastructure;

public interface UdiseInfrastructureRepository extends JpaRepository<UdiseInfrastructure, Long>{

@Query(nativeQuery = true, value = "select * from moe_udise_infrastructure ut where region_type=:region_type and region_id=:regionId and item_group=:itemGroup and item_id=:itemId and value_type=:valueType")
 List<UdiseInfrastructure>  getInfrastucture(String region_type,int regionId,int itemGroup, int itemId,int valueType);
	
}
