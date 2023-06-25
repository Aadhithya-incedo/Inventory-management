package com.inventory.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.main.models.InwardRegister;
import com.inventory.main.persistence.InwardRepository;

@Service
public class InwardService {
	
	@Autowired
	public InwardRepository inwardRepository;

	public InwardRegister insert(InwardRegister inward) {
		return inwardRepository.save(inward);
	}

	public List<InwardRegister> getAll() {
		return inwardRepository.findAll();
	}

	
}
