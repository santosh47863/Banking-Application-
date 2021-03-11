package com.cg.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.bank.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

}
