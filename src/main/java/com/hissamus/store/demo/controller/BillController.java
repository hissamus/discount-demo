package com.hissamus.store.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hissamus.store.demo.config.GlobalExceptionHandler;
import com.hissamus.store.demo.model.Bill;
import com.hissamus.store.demo.service.BillService;

@RestController
@RequestMapping("/api")
public class BillController {
	private static Logger logger = LoggerFactory.getLogger(BillController.class);
	@Autowired
	private BillService billservice;
	
	@PostMapping(value = "/checkout/")
	public ResponseEntity<Bill> action(@RequestParam("user") String userName, @RequestParam("selectedItems")String[] items) {
		logger.info("user"+userName+"||selectedItems"+items.toString());
		 return new ResponseEntity<Bill>(billservice.checkout(userName, items), HttpStatus.OK);
	}

}
