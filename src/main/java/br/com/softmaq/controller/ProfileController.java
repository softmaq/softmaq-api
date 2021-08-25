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
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profile saveProfile(@RequestBody Profile profile) {
		return profileService.save(profile);
	}

	@PutMapping
	public Profile updateProfile(@RequestBody Profile profile) {
		return profileService.save(profile);
	}
	
	@PutMapping("/{id}")
	public Profile updateProfileById(@PathVariable Long id, @RequestBody Profile profileUpdate) {
		return profileService.updateProfileById(id,profileUpdate);

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteProfile(@PathVariable Long id) {
		profileService.deleteProfile(id);
	}

}
