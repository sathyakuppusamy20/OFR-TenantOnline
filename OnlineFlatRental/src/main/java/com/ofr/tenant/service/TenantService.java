package com.ofr.tenant.service;

import java.util.List;
import java.util.Optional;

import com.ofr.tenant.entities.Tenant;
import com.ofr.tenant.exception.TenantNotFoundException;

public interface TenantService {
	
	public Tenant addTenant(Tenant tenant);

	public Tenant updateTenant(Tenant tenant)throws TenantNotFoundException;

	public Tenant deleteTenant(Tenant tenant)throws TenantNotFoundException;

	public Optional<Tenant> viewTenant(Integer tenantId)throws TenantNotFoundException;

	public List<Tenant> viewAllTenant();

	public boolean validateTenant(Integer tenantId)throws TenantNotFoundException;

	

}
