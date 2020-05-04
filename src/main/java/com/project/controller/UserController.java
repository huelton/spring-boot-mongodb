package com.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User(1L,"maria","maria@gmail.com");
		User joao = new User(2L,"joao","joao@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, joao));
		
		return ResponseEntity.ok().body(list);
		
	}
}
