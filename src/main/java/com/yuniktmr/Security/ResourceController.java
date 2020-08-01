package com.yuniktmr.Security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@RequestMapping("/helloUser")
	public String getUser() {
		return "Regular User";
	}
	
	@RequestMapping("/helloAdmin")
	public String getAdmin() {
		return "Admin";
	}
}
