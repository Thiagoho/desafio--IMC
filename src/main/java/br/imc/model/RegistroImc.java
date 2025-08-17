package br.imc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "registro_imc")

@NoArgsConstructor

@AllArgsConstructor
public class RegistroImc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegi;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal imc;

    @Column(name = "data_registro", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataRegistro;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    // Relacionamento com Usuario (idUser)
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    // Relacionamento com ClassificacaoImc (idClassif)
    @ManyToOne
    @JoinColumn(name = "idClassif")
    private ClassificacaoImc classificacao;
}
