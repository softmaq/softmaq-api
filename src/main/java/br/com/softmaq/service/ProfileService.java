package br.com.softmaq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softmaq.domain.Profile;
import br.com.softmaq.exception.ResourceNotFoundException;
import br.com.softmaq.repository.ProfileRepository;

@Service
public class ProfileService {  
	
	@Autowired
	public ProfileRepository profileRepository;

	public List<Profile> findAllProfiles() {
		return profileRepository.findAll();
	}
	
	public Optional<Profile> findById(Long id) {
		return profileRepository.findById(id);
	}

	public void delete(Profile profile) {
		profileRepository.delete(profile);
	}

	public Profile save(Profile profile) {
		return profileRepository.save(profile);
	}

	public Profile updateProfileById(Long id, Profile profileUpdate) {
		
		findById(id).orElseThrow( () -> new ResourceNotFoundException("Profile "+ id + " Not Found"));
		profileUpdate.setProfileId(id);
		return save(profileUpdate);
	}

	public void deleteProfile(Long id) {
		Profile profile = findById(id).orElseThrow( () -> new ResourceNotFoundException("Profile "+ id + " Not Found"));
		profileRepository.delete(profile);
		
	}
}
