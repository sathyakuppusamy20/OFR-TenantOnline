package com.ofr.tenant.exception;

public class TenantNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TenantNotFoundException(String msg) {
		super(msg);
	}

}
