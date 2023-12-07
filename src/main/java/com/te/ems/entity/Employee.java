package com.te.ems.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Entity
public class Employee {
	@Id
	private String employeeId;
	private String employeeName;
	private int employeeAge;

	@JoinColumn(name = "ba_fk")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BankAccount bankAccount;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employee")
	private List<Address> addresses = new ArrayList<Address>();

	@JoinTable(
			name = "e_s_map", 
			joinColumns = @JoinColumn(name = "e_fk"), 
			inverseJoinColumns = @JoinColumn(name = "s_fk")
	)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Skill> skills = new ArrayList<Skill>();
}
