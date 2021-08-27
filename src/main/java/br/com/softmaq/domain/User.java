package br.com.softmaq.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "TB_USUARIO")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long userId;
	
	@Column(name = "NM_USER", nullable = false)
	private String userName;
	
	@Column(name = "ID_PERFIL")
	private Long profileId;
	
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "DT_CADASTRO")
	private LocalDate created;
	
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "DT_ATUALIZACAO")
	private LocalDate updated;
	
	@Column(name = "FL_STATUS")
	private Integer status;
	
}
