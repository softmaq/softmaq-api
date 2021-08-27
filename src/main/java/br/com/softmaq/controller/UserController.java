package br.com.softmaq.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.softmaq.constant.Log;
import br.com.softmaq.domain.User;
import br.com.softmaq.repository.UserRepository;
import br.com.softmaq.util.Util;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User saveUser(@RequestBody User user) throws JsonProcessingException {
		log.info(Log.MSG,"saveUser", "save", "Salvando: " + Util.Obj2JSon(user));
		return userRepository.save(user);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) throws JsonProcessingException {
		log.info(Log.MSG,"updateUser", "update", "Atualizando: " + Util.Obj2JSon(user));
		return userRepository.save(user);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteUser(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
	}
	
}
