package br.com.softmaq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softmaq.domain.Profile;
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
}
