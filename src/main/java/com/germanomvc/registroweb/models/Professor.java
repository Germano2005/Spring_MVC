package com.germanomvc.registroweb.models;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;


@Entity
public class Professor {
    @Id // Setando o ID da entidade professor
    @GeneratedValue(strategy = GenerationType.IDENTITY) //quando eu for criar um novo registro de professor no bd, próprio bd cria um id incremental e único
    private long id;
    @Column(nullable = false)
    private String nome;
    private BigDecimal salario;
    @Enumerated(EnumType.STRING) // quando for guardado no banco o status do professor, ele será guardado na forma de uma String
    private EStatusProfessor statusProfessor;

    public Professor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public EStatusProfessor getStatusProfessor() {
        return statusProfessor;
    }

    public void setStatusProfessor(EStatusProfessor statusProfessor) {
        this.statusProfessor = statusProfessor;
    }
}
