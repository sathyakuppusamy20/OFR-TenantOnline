package com.ofr.tenant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofr.tenant.dao.TenantDao;
import com.ofr.tenant.entities.Tenant;
import com.ofr.tenant.exception.TenantNotFoundException;

@Service("tenantservice")
@Transactional
public class TenantServiceImpl implements TenantService {

	@Autowired
	private TenantDao dao;
    String tenantNotFound = "tenant id not Found";
	@Override
	public Tenant addTenant(Tenant tenant) {
		dao.save(tenant);
		return tenant;
	}

	@Override
	public Tenant updateTenant(Tenant tenant) throws TenantNotFoundException {
		Optional<Tenant> tenant1 = dao.findById(tenant.getTenant_id());
		if(tenant1.isPresent())
		{
			return dao.save(tenant);
		}
		else
		{
			throw new TenantNotFoundException(tenantNotFound);
		}
	}

	@Override
	public Tenant deleteTenant(Tenant tenant) throws TenantNotFoundException {
		Optional<Tenant> tenant1 = dao.findById(tenant.getTenant_id());
		if(tenant1.isPresent())
		{
			  dao.delete(tenant);
		}
		else
		{
			throw new TenantNotFoundException(tenantNotFound);
		}
		return tenant;
	}

	@Override
	public Optional<Tenant> viewTenant(Integer tenantId)throws TenantNotFoundException {
	Optional<Tenant> tenant= dao.findById(tenantId);
	if(tenant.isPresent())
	{
		return tenant;
		
	}
	else
	{
		throw new TenantNotFoundException(tenantNotFound);
	}
	}

	@Override
	public List<Tenant> viewAllTenant() {
		return dao.findAll();
	}

	@Override
	public boolean validateTenant(Integer tenantId) throws TenantNotFoundException {
		boolean tenant=dao.existsById(tenantId);
		if(tenant==false)
		{
			throw new TenantNotFoundException(tenantNotFound);
		}
		return true;
	}

}
