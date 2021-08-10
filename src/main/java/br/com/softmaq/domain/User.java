package br.com.softmaq.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "TB_USUARIO")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long userId;
	
	@Column(name = "NM_USER", nullable = false)
	private String userName;
	
	@Column(name = "ID_PERFIL")
	private Long profileId;
	
	@Column(name = "DT_CADASTRO")
	private LocalDate created;
	
	@Column(name = "DT_ATUALIZACAO")
	private LocalDate updated;
	
	@Column(name = "FL_STATUS")
	private Integer status;
	
}
