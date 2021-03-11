package com.cg.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bank.dto.CustomerDto;
import com.cg.bank.service.CustomerService;

@RestController
//@Controller
@RequestMapping("/bank")
public class CustomerAPI {
	@Autowired
	CustomerService service;
	//@RequestMapping(value="/customer/{cid}",method = RequestMethod.GET)
	//requestparam
	
	@GetMapping("/customer/{cid}")	
	 public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("cid") int cid) {
		 CustomerDto dto= service.getCustomerById(cid);
		 return new ResponseEntity<>(dto,HttpStatus.OK);
	 }
	
	//@RequestMapping(value="/customer", method=RequestMethod.POST)
	@PostMapping("/customer")
	public ResponseEntity<String>addCustomer(@RequestBody CustomerDto dto) {
		service.addCustomer(dto);
		return new ResponseEntity<>("Customer added Successfully",HttpStatus.CREATED);
	}
	//@RequestMapping(value="/customer/{cid}/{add}", method=RequestMethod.PUT)
	@PutMapping("/customer/{cid}/{add}")
	public ResponseEntity<String> updateCustomerAddress(@PathVariable("cid")int cid, @PathVariable("add")String newAddress) {
		boolean result=service.updateCustomer(cid, newAddress);
		if(result)
			//return " cusotmer updated successfully";
			return new ResponseEntity<>("customer updated successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("record not found", HttpStatus.BAD_REQUEST);
	}
	//@RequestMapping(value="/customer", method=RequestMethod.PUT)
	@PutMapping("/customer")
	public String updateAllCustomers() {
		service.updateCustomer();
		return "updation done";
	}

	
}
