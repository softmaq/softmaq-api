package br.com.softmaq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softmaq.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
