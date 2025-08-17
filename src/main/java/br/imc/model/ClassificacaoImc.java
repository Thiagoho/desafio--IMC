package br.imc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "classificacoes_imc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassificacaoImc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClassif;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(name = "imc_minimo", nullable = false, precision = 5, scale = 2)
    private BigDecimal imcMinimo;

    @Column(name = "imc_maximo", nullable = false, precision = 5, scale = 2)
    private BigDecimal imcMaximo;

    @Column(name = "risco_saude", nullable = false, length = 100)
    private String riscoSaude;
}
