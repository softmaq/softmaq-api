package br.com.softmaq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softmaq.domain.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
