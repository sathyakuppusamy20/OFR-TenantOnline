package com.ofr.tenant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofr.tenant.entities.Tenant;

public interface TenantDao extends JpaRepository<Tenant,Integer> {

}
