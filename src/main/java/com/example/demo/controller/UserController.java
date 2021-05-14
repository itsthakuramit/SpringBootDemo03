package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> userlist = userService.getAllUsers();
		return new ResponseEntity<>(userlist,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user){
		User addeduser = userService.addUser(user);
		return new ResponseEntity<>(addeduser,HttpStatus.CREATED);
	}
	

	
}
