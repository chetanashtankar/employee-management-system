package com.te.ems.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDTO {
	private String employeeName;
	private int employeeAge;
	
	private List<AddressDTO> addresses;
	
	private List<SkillDTO> skills;
}
