package br.com.softmaq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.softmaq.constant.Log;
import br.com.softmaq.domain.Profile;
import br.com.softmaq.exception.ResourceNotFoundException;
import br.com.softmaq.repository.ProfileRepository;
import br.com.softmaq.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProfileService {  
	
	@Autowired
	public ProfileRepository profileRepository;

	public List<Profile> findAllProfiles() {
		log.info(Log.MSG, "findAllProfiles", "list", "Listando todos os perfis");
		return profileRepository.findAll();
	}
	
	public Optional<Profile> findById(Long id) throws Exception {
		log.info(Log.MSG, "findById", "find", "Buscando id "+ id ) ;
		return profileRepository.findById(id);
	}

	public void delete(Profile profile) throws Exception {
		log.info(Log.MSG, "delete", "delete", "Apagando perfil "+ Util.Obj2JSon(profile) ) ;
		profileRepository.delete(profile);
	}

	public Profile save(Profile profile) throws  Exception {
		log.info("method={} event={} message={}", "save", "save", Util.Obj2JSon(profile));
		return profileRepository.save(profile);
	}

	public Profile updateProfileById(Long id, Profile profileUpdate) throws  Exception {
		findById(id).orElseThrow( () -> new ResourceNotFoundException("Profile "+ id + " Not Found"));
		profileUpdate.setProfileId(id);
		return save(profileUpdate);
	}

	public void deleteProfile(Long id) throws ResourceNotFoundException, Exception {
		Profile profile = findById(id).orElseThrow( () -> new ResourceNotFoundException("Profile "+ id + " Not Found"));
		log.info(Log.MSG, "deleteProfile", "delete", "Apagando perfil "+ Util.Obj2JSon(profile)) ;
		profileRepository.delete(profile);
		
	}
}
