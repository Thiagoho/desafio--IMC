package br.imc.model;




import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data

@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal altura;

   // @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    
    // Enum interno para os valores do campo sexo
    public enum Sexo {
        M, F, OUTRO
    }
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
}
