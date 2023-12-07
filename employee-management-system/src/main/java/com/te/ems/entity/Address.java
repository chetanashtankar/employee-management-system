package com.te.ems.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Address {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int addressId;
	private String city;
	private String state;
	
	@JoinColumn(name = "e_fk")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Employee employee;
	
	
	
}
