package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.User;
import com.project.dto.UserDTO;
import com.project.form.UserForm;
import com.project.repository.UserRepository;
import com.project.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj);
	}

	public User fromDto(UserForm user) {

		return new User(null, user.getNome(), user.getEmail());

	}
	
	private void updateData(User newObj, User obj) {

		newObj.setNome(obj.getNome()); 
		newObj.setEmail(obj.getEmail()); 
		
	}
}
