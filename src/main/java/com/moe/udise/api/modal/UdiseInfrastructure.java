package com.moe.udise.api.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "moe_udise_infrastructure")
public class UdiseInfrastructure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="region_type")
	private String regionType;
	@Column(name="region_id")
	private Integer regionId;
	@Column(name="region_name")
	private String regionName;
	@Column(name="item_group")
	private Integer itemGroup;
	@Column(name="item_id")
	private Integer itemId;
	@Column(name="value_type")
	private Float valueType;
	@Column(name="total_schools")
	private Float totalSchools;
	@Column(name="classrooms")
	private Float classrooms;
	@Column(name="toiletg")
	private Float toiletg;
	@Column(name="electricity")
	private Float electricity;

}
