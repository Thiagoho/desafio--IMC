package br.imc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "registro_imc")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegistroImc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegi;
	
	private Double peso;
	private Double imc;
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	@JsonIgnore
	private Usuario usuario;
	

}
