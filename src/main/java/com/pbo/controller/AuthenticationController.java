package com.pbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pbo.model.Authentication;
import com.pbo.model.User;
import com.pbo.repository.AuthenticationRepository;
import com.pbo.repository.UserRepository;

@RestController
@RequestMapping("/api/authentications")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

	@Autowired
	private AuthenticationRepository authenticationRepository;

    @Value("${jwt.secret}")
    private String JWT_SECRET;
	
	@GetMapping
	public List<Authentication> getAllAuthentications() {
		return authenticationRepository.findAll();
	}
	
	@PostMapping
	public Authentication createAuthentication(@RequestBody User user) {
        user = userRepository.findById(user.getId()).orElse(null);
        if (user == null) return null;

        String token = JWT.create()
            .withClaim("id", user.getId())
            .withClaim("email", user.getEmail())
            .withClaim("displayname", user.getDisplayName())
            .withClaim("role", user.getRole())
            .sign(Algorithm.HMAC256(JWT_SECRET));

		return authenticationRepository.save(new Authentication(token));
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
