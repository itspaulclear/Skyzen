package com.app.controller;

import com.app.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/method")
public class TestAuthController {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@GetMapping("/get")
	public List<Object[]> getUsers() {
		return userDetailsService.getUsers();
	}
	// Gestionado por AuthenticationController
	/*
	@PostMapping("/post")
	public String helloPost(){
		return "Hello World - POST";
	}
	*/

	@PutMapping("/put")
	public String helloPut(){
		return "Hello World - PUT";
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username) {
		try {
			userDetailsService.deleteUserByUsername(username);
			return ResponseEntity.ok("Usuario eliminado con éxito");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
		}
	}

}
