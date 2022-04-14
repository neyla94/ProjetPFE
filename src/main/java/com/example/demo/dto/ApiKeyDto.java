package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class ApiKeyDto {
	private Long id;
	private String ipadress;
	private String apikeyValue;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public ApiKeyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIpadress() {
		return ipadress;
	}

	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}

	public String getApikeyValue() {
		return apikeyValue;
	}

	public void setApikeyValue(String apikeyValue) {
		this.apikeyValue = apikeyValue;
	}

	public ApiKeyDto(Long id, String ipadress, String apikeyValue
			) {
		super();
		this.id = id;
		this.ipadress = ipadress;
		this.apikeyValue = apikeyValue;
	}

	public ApiKeyDto(String ipadress, String apikeyValue) {
		super();
		this.ipadress = ipadress;
		this.apikeyValue = apikeyValue;
	}

}
