package com.glaucus.Counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	public NumberRepository numRepo;

	private int requestCounter=0;
	/**
	 * @return This method return count of each HTTP Request.
	 */
	@GetMapping("/counter")
	public void getCounter() {
		if(requestCounter > 100) {
			throw new InvalidApiRequest("Invalid Api Request");
		}
	    numRepo.save(new Number(requestCounter++));	
	    
   }
	
	
	
}
