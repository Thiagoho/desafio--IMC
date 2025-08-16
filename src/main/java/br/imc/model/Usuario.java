package br.imc.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor

public class Usuario {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String email;
	private LocalDate dataNascimento;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private Double altura;
	private LocalDate dataCriacao = LocalDate.now();
	
	// Construtor
	public  Usuario() {}
	

}
