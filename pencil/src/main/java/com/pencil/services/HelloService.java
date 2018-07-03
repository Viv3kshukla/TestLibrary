package com.pencil.application.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public String welcome() {
		return "Welcome Users";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String anyway() {
		return "Anyway , I don't care ";
	}
	
	
	public String publicAccess() {
		return "Hey , this is public access ";
	}
	
}
