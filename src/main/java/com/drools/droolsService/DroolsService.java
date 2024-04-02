package com.drools.droolsService;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.entity.Order;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DroolsService {

//	
//	  private final KieContainer kieContainer;
//
//	  
//	    public DroolsService(KieContainer kieContainer) {
//	        this.kieContainer = kieContainer;
//	    }

	@Autowired
	private KieContainer kieContainer;
	
	    public Order takeOrder(Order order) {
	        log.info("take order service entry {}", order);
	        KieSession kieSession = kieContainer.newKieSession();
	        kieSession.insert(order);
	        kieSession.fireAllRules();
	        kieSession.dispose();
	        log.info("take order service after insert {}", order);
	        return order;
	    }
	
	
	
	 
}
