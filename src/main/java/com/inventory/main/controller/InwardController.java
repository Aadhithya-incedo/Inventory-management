package com.inventory.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.main.models.Godown;
import com.inventory.main.models.InwardRegister;
import com.inventory.main.models.Product;
import com.inventory.main.models.Supplier;
import com.inventory.main.service.GodownService;
import com.inventory.main.service.InwardService;
import com.inventory.main.service.ProductService;
import com.inventory.main.service.SupplierService;

@RestController
@RequestMapping("/inward")
public class InwardController {

	@Autowired
	public GodownService godownService;
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public SupplierService supplierService;
	
	@Autowired
	public InwardService inwardService;
	
	@PostMapping("/add/{productId}/{godownId}/{supplierId}")
	public ResponseEntity<?> addInward(@RequestBody InwardRegister inward,
			@PathVariable("productId") int productId, 
			@PathVariable("godownId") int godownId, 
			@PathVariable("supplierId") int supplierId){
		Godown godownFound = godownService.getById(godownId);
		if(godownFound == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Godown ID");
		}
		
		Product productFound = productService.getById(productId);
		if(productFound == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Product ID");
		}
		
		Supplier supplierFound = supplierService.getById(supplierId);
		if(supplierFound == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Supplier ID");
		}
		
		inward.setGodown(godownFound);
		inward.setSupplier(supplierFound);
		inward.setProduct(productFound);
		inward.setDateOfSupply(LocalDate.now());
		
		inward = inwardService.insert(inward);
		
		return ResponseEntity.status(HttpStatus.OK).body(inward);
	}
	
	@GetMapping("/get")
	public List<InwardRegister> getAllInward(){
		return inwardService.getAll();
	}
	
}
