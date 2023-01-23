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
@Table(name = "enrollment_dt_01",schema = "api_2122")
public class EnrollmentDt01 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="region_type")
	private String regionType;
	@Column(name="parent_region_type")
	private String parentRegionType;
	@Column(name="parent_region_id")
	private Integer parentRegionId;
	@Column(name="parent_region_code")
	private String parentRegionCode;
	@Column(name="parent_region_name")
	private String parentRegionName;
	@Column(name="region_id")
	private Integer regionId;
	@Column(name="region_code")
	private String regionCode;
	@Column(name="region_name")
	private String regionName;
	@Column(name="item_group_id")
	private Integer itemGroupId;
	@Column(name="item_group_name")
	private String itemGroupName;
	@Column(name="item_id")
	private Integer itemId;
	@Column(name="item_name")
	private String itemName;
	@Column(name="value_type")
	private Integer valueType;
	@Column(name="cpp_b")
	private Float cppB;
	@Column(name="cpp_g")
	private Float cppG;
	@Column(name="c1_b")
	private Float c1B;
	@Column(name="c2_b")
	private Float c2B;
	@Column(name="c3_b")
	private Float c3B;
	@Column(name="c4_b")
	private Float c4B;
	@Column(name="c5_b")
	private Float c5B;
	@Column(name="c6_b")
	private Float c6B;
	@Column(name="c7_b")
	private Float c7B;
	@Column(name="c8_b")
	private Float c8B;
	@Column(name="c9_b")
	private Float c9B;
	@Column(name="c10_b")
	private Float c10B;
	@Column(name="c11_b")
	private Float c11B;
	@Column(name="c12_b")
	private Float c12B;
	@Column(name="c1_g")
	private Float c1G;
	@Column(name="c2_g")
	private Float c2G;
	@Column(name="c3_g")
	private Float c3G;
	@Column(name="c4_g")
	private Float c4G;
	@Column(name="c5_g")
	private Float c5G;
	@Column(name="c6_g")
	private Float c6G;
	@Column(name="c7_g")
	private Float c7G;
	@Column(name="c8_g")
	private Float c8G;
	@Column(name="c9_g")
	private Float c9G;
	@Column(name="c10_g")
	private Float c10G;
	@Column(name="c11_g")
	private Float c11G;
	@Column(name="c12_g")
	private Float c12G;
	@Column(name="cpp")
	private Float cpp;
	@Column(name="c1")
	private Float c1;
	@Column(name="c2")
	private Float c2;
	@Column(name="c3")
	private Float c3;
	@Column(name="c4")
	private Float c4;
	@Column(name="c5")
	private Float c5;
	@Column(name="c6")
	private Float c6;
	@Column(name="c7")
	private Float c7;
	@Column(name="c8")
	private Float c8;
	@Column(name="c9")
	private Float c9;
	@Column(name="c10")
	private Float c10;
	@Column(name="c11")
	private Float c11;
	@Column(name="c12")
	private Float c12;
	@Column(name="total_b")
	private Float totalB;
	@Column(name="total_g")
	private Float totalG;
	@Column(name="no_of_student_with_pre")
	private Float noOfStudentWithPre;
	@Column(name="no_of_student")
	private Float noOfStudent;
	@Column(name="primary_b")
	private Float primaryB;
	@Column(name="primary_g")
	private Float primaryG;
	@Column(name="primary_t")
	private Float primaryT;
	@Column(name="upper_primary_b")
	private Float upperPrimaryB;
	@Column(name="upper_primary_g")
	private Float upperPrimaryG;
	@Column(name="upper_primary_t")
	private Float upperPrimaryT;
	@Column(name="elementary_b")
	private Float elementaryB;
	@Column(name="elementary_g")
	private Float elementaryG;
	@Column(name="elementary_t")
	private Float elementaryT;
	@Column(name="secondary_b")
	private Float secondaryB;
	@Column(name="secondary_g")
	private Float secondaryG;
	@Column(name="secondary_t")
	private Float secondaryT;
	@Column(name="higher_secondary_b")
	private Float higherSecondaryB;
	@Column(name="higher_secondary_g")
	private Float higherSecondaryG;
	@Column(name="higher_secondary_t")
	private Float higherSecondaryT;
}
