package com.te.ems.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.annotations.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.te.ems.dto.AddressDTO;
import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.SkillDTO;
import com.te.ems.entity.Employee;

@Component
public class EmployeeUtils {

	public EmployeeDTO entityToDTO(Employee employee) {

		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee, employeeDTO);
		employeeDTO.setAddresses(employee.getAddresses().stream()
				.map(a -> AddressDTO.builder().city(a.getCity()).state(a.getState()).build())
				.collect(Collectors.toList()));
		employeeDTO.setSkills(employee.getSkills().stream()
				.map(s -> SkillDTO.builder().skillName(s.getSkillName()).build()).collect(Collectors.toList()));
		return employeeDTO;

	}
}
