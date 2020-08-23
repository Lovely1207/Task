package com.glaucus.Counter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private static AtomicInteger counter = new AtomicInteger();
	private static Integer n = null;
	private static Number numObject;
	@Autowired
	public NumberRepository numRepo;

	/**
	 * @return This method return count of each HTTP Request.
	 */
	@GetMapping("/counter")
	public void getCounter() {
		
		try {
		if(counter.get() >0) {
	     n=counter.get();
		List<Number> numObject = numRepo.findByCount(n);
		if(numObject != null && numObject.size() >0) {
			//System.out.println("object found to increment .");
			Number numObj = numObject.get(0);
			n = counter.incrementAndGet();
			numObj.setCount(n);
			numRepo.save(numObj);
		}
		}else {
			n = counter.incrementAndGet();
			numObject = new Number(n);
			numRepo.save(numObject);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		 
   }
	
}
