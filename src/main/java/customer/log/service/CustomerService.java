package customer.log.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.log.model.CustomerLog;
import customer.log.repositary.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo repo;
	
	
	public void saveInLog(CustomerLog customer) {
		repo.save(customer);
	}
	
	public ArrayList<CustomerLog> getLog(String date){
		ArrayList<CustomerLog> logs=repo.findByDate(date);
		return logs;
	}

	public ArrayList<CustomerLog> getAllLog() {
		ArrayList<CustomerLog> logs=(ArrayList<CustomerLog>) repo.findAll();
		return logs;
	}
}
