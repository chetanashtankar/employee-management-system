package com.te.ems.service;

import static com.te.ems.constants.EmployeeConstants.EMPLOYEE_DATA_NOT_FOUND;

import org.springframework.stereotype.Service;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.entity.Employee;
import com.te.ems.exception.EmployeeNotFoundException;
import com.te.ems.repository.EmployeeRepository;
import com.te.ems.utils.EmployeeUtils;

@Service
public record EmployeeService(EmployeeRepository employeeRepository, EmployeeUtils employeeUtils) {

	public EmployeeDTO getEmployee(String employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_DATA_NOT_FOUND));
		return employeeUtils.entityToDTO(employee);
	}

}
