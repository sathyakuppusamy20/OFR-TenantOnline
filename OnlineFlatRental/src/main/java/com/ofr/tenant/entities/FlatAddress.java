
package com.ofr.tenant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "FlatAddress")
public class FlatAddress {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "House_No")
	private Integer houseNo;

	@Column(name = "Street")
	private String street;

	@Column(name = "State")
	private String state;

	@Column(name = "City")
	private String city;

	@Column(name = "Pin")
	private Integer pin;

	@Column(name = "Country")
	private String country;

	@OneToOne(targetEntity=Tenant.class)
	
	private Tenant tenant;
	
	
	
	public FlatAddress() {
		super();
		
	}

	public FlatAddress(Integer houseNo, String street, String state, String city, Integer pin, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.state = state;
		this.city = city;
		this.pin = pin;
		this.country = country;
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "FlatAddress [houseNo=" + houseNo + ", street=" + street + ", state=" + state + ", city=" + city
				+ ", pin=" + pin + ", country=" + country + "]";
	}
}
