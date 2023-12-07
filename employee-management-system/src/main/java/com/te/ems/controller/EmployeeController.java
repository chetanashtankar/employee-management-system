package com.te.ems.controller;

import static com.te.ems.constants.EmployeeConstants.EMPLOYEE_DATA_PROVIDED;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.response.SuccessResponse;
import com.te.ems.service.EmployeeService;

@RequestMapping(path = "api/v1/employees")
@RestController
public record EmployeeController(EmployeeService employeeService) {

	@GetMapping(path = "/employee")
	public ResponseEntity<SuccessResponse> getEmployee(@RequestParam(name = "id") String employeeId) {
		return ResponseEntity.<SuccessResponse>ok()
				    .body(SuccessResponse
					.builder()
					.data(employeeService.getEmployee(employeeId))
					.message(EMPLOYEE_DATA_PROVIDED)
					.timestamp(LocalDateTime.now())
					.build()
				);
	}

	
}
