package com.ofr.tenant.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tenant")
public class Tenant {

	@Id
	@Column(name = "Tenant_Id", length = 20)
	@Min(value=1,message="id should be positive")
	private Integer tenant_id;
	@Max(value=100,message="age should not be greater than 100")
	@Column(name = "Age", length = 20)
	private Integer age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FlatAddress")
	private FlatAddress taddress;

	public Tenant() {

	}

	public Tenant(Integer tenant_id, Integer age, FlatAddress taddress) {
		super();
		this.tenant_id = tenant_id;
		this.age = age;
		this.taddress = taddress;
	}

	public Integer getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(Integer tenant_id) {
		this.tenant_id = tenant_id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public FlatAddress getTaddress() {
		return taddress;
	}

	public void setTaddress(FlatAddress taddress) {
		this.taddress = taddress;
	}

	@Override
	public String toString() {
		return "Tenant [tenant_id=" + tenant_id + ", age=" + age + "]";
	}
}
