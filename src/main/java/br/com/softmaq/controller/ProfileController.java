package br.com.softmaq.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softmaq.domain.Profile;
import br.com.softmaq.service.ProfileService;

@RestController
@RequestMapping("v1/profiles")
public class ProfileController {
	
	@Autowired
	public ProfileService profileService;
	
	@GetMapping
	public List<Profile> findAllProfiles() {
		return  profileService.findAllProfiles();
	}
	
	@GetMapping("/{id}")
	public Optional<Profile> findById(@PathVariable Long id) {
		return profileService.findById(id);
	}

}
