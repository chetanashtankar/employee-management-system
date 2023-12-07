package com.te.ems;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.te.ems.entity.Address;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Skill;
import com.te.ems.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class EMSApplication {

	private final EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EMSApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			Address address01 = Address.builder().city("BLR").state("KARNATAKA").build();
			Address address02 = Address.builder().city("HYD").state("TELANGANA").build();
			Skill skill01 = Skill.builder().skillName("Java").employees(new ArrayList<Employee>()).build();
			Employee employee = Employee.builder().employeeId(UUID.randomUUID().toString()).employeeAge(22)
					.employeeName("A").addresses(List.of(address01, address02)).skills(List.of(skill01)).build();
			address01.setEmployee(employee);
			address02.setEmployee(employee);
			skill01.getEmployees().add(employee);

			employeeRepository.save(employee);

		};
	}

}
