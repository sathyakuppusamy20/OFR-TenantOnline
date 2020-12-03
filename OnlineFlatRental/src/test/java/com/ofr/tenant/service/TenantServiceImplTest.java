package com.ofr.tenant.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.ofr.tenant.dao.TenantDao;
import com.ofr.tenant.entities.FlatAddress;
import com.ofr.tenant.entities.Tenant;
import com.ofr.tenant.exception.TenantNotFoundException;

@TestInstance(Lifecycle.PER_CLASS)
class TenantServiceImplTest {

	@Mock
	TenantServiceImpl service;

	@Mock
	TenantDao dao;

	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddTenant() {
		FlatAddress flatad = new FlatAddress(1, "nethaji", "cudd", "tn", 64566, "Us");
		Tenant tenant = new Tenant(11, 10, flatad);
		service.addTenant(tenant);
		assertEquals(10,tenant.getAge());
		verify(service,times(1)).addTenant(tenant);
	}

	@Test
	void testUpdateTenant() throws TenantNotFoundException {
		FlatAddress flatad = new FlatAddress(21, "gandhi", "cbe", "tn", 64367, "India");
		Tenant tenant = new Tenant(2, 20, flatad);
		service.addTenant(tenant);
		tenant.setAge(22);
		service.updateTenant(tenant);
		assertEquals(22,tenant.getAge());
		verify(service,times(1)).updateTenant(tenant);
	}

	@Test
	void testDeleteTenant() throws TenantNotFoundException {
		FlatAddress flatad = new FlatAddress(31, "vishnust", "che", "hy", 64289, "JP");
		Tenant tenant = new Tenant(3, 30, flatad);
		service.deleteTenant(tenant);
		verify(service,times(1)).deleteTenant(tenant);
		assertNotNull(service);
	}

	@Test
	void testViewTenant() throws TenantNotFoundException {
		FlatAddress flatad = new FlatAddress(41, "sat", "mad", "ban", 64343, "AP");
		Tenant tenant = new Tenant(4, 40, flatad);
		service.addTenant(tenant);
		Optional<Tenant> findById = Optional.ofNullable(tenant);
		when(service.viewTenant(4)).thenReturn(findById);
		Optional<Tenant> findById2 = service.viewTenant(4);
		assertEquals(findById, findById2);
	}

	@Test
	void testViewAllTenant() {
		List<Tenant> tenantList = new ArrayList<Tenant>();
		FlatAddress flatad = new FlatAddress(51, "hema", "pollachi", "che", 64222, "UP");
		Tenant tenant = new Tenant(5, 50, flatad);
		tenantList.add(tenant);
		when(service.viewAllTenant()).thenReturn(tenantList);
		List<Tenant> tenantList1 = service.viewAllTenant();
		assertEquals(1, tenantList1.size());
		verify(service,times(1)).viewAllTenant();
		
	}

	/*@Test
	void testValidateTenant() throws TenantNotFoundException {
		boolean tenant = service.validateTenant(20);
		assertNull(tenant);
	}*/

}
