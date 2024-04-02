package com.drools.droolsControllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.drools.droolsService.DroolsService;
import com.drools.entity.Order;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class DroolsControllor {
	
	@Autowired
	private DroolsService droolsService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Order>postOrder(@RequestBody Order order)
	{
		log.info("Drools controllor entry {}",order);
		       Order takeOrder = droolsService.takeOrder(order);
		log.info("Drools controllor after service operation {}",takeOrder);
		return ResponseEntity.ok(takeOrder);
		
	}

}
