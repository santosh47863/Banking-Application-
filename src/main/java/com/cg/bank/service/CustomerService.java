package com.cg.bank.service;

import com.cg.bank.dto.CustomerDto;

public interface CustomerService {
	void addCustomer(CustomerDto dto);
	CustomerDto getCustomerById(Integer cid);
	boolean updateCustomer(int cid, String newAddress);
	void updateCustomer();
}
