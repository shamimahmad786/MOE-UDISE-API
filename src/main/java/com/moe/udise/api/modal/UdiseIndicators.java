package com.moe.udise.api.modal;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "moe_udise_indicator")

public class UdiseIndicators {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="region_type")
	private  String regionType;
	@Column(name="region_id")
	private  Integer regionId;
	@Column(name="region_name")
	private  String regionName;
	@Column(name="item_group")
	private  Float itemGroup;
	@Column(name="item_id")
	private  Float itemId;
	@Column(name="value_type")
	private  Float valueType;
	@Column(name="c1")
	private  Float c1;
	@Column(name="c2")
	private  Float c2;
	@Column(name="c3")
	private  Float c3;
	@Column(name="c4")
	private  Float c4;
	@Column(name="c5")
	private  Float c5;
	@Column(name="c6")
	private  Float c6;
	@Column(name="c7")
	private  Float c7;
	@Column(name="c8")
	private  Float c8;
	@Column(name="c9")
	private  Float c9;
	@Column(name="c10")
	private  Float c10;
	@Column(name="c11")
	private  Float c11;	
	@Column(name="c12")
	private  Float c12;	
	@Column(name="Primaryes")
	private  Float Primary;
	@Column(name="upper_primary")
	private  Float upperPrimary;
	@Column(name="elementary")
	private  Float elementary;
	@Column(name="secondary")
	private  Float secondary;
	@Column(name="higher_secondary")
	private  Float higherSecondary;
	
	
	
	

}
