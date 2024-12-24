package com.pbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbo.model.Authentication;
import com.pbo.repository.AuthenticationRepository;

@RestController
@RequestMapping("/api/authentications")
public class AuthenticationController {

	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	@GetMapping
	public List<Authentication> getAllAuthentications() {
		return authenticationRepository.findAll();
	}
	
	@PostMapping
	public Authentication createAuthentication(@RequestBody Authentication authentication) {
		return authenticationRepository.save(authentication);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Authentication> getAuthenticationById(@PathVariable Long id) {
		return authenticationRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAuthentication(@PathVariable Long id) {
		return authenticationRepository.findById(id)
				.map(auth -> {
					authenticationRepository.delete(auth);
					return ResponseEntity.noContent().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
