package com.cg.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.dto.CustomerDto;
import com.cg.bank.entity.CustomerEntity;
import com.cg.bank.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository repository;
	@Override
	public void addCustomer(CustomerDto dto) {
		// TODO Auto-generated method stub
		CustomerEntity entity = new CustomerEntity();
		entity.setAddress(dto.getAddress());
		entity.setCustomerId(dto.getCustomerId());
		entity.setCustomerName(dto.getCustomerName());
		repository.save(entity);
		
	}

	@Override
	public CustomerDto getCustomerById(Integer cid) {
		// TODO Auto-generated method stub
		CustomerEntity entity = repository.findById(cid).get();
		CustomerDto dto = new CustomerDto();
		dto.setAddress(entity.getAddress());
		dto.setCustomerId(entity.getCustomerId());
		dto.setCustomerName(entity.getCustomerName());
		return dto;
	}

	@Override
	public boolean updateCustomer(int cid, String newAddress) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> opt=repository.findById(cid);
		if(opt.isPresent()) {
			CustomerEntity entity = opt.get();
			entity.setAddress(newAddress);
			return true;
			
		}
		return false;
			
	}

	@Override
	public void updateCustomer() {
		// TODO Auto-generated method stub
	List<CustomerEntity>list=	(List<CustomerEntity>)repository.findAll();
	for (CustomerEntity customerEntity : list) {
		customerEntity.setAddress("delhi");
	}
	
	}

}
