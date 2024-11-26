package com.germanomvc.registroweb.dto;

import com.germanomvc.registroweb.models.EStatusProfessor;
import com.germanomvc.registroweb.models.Professor;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

// é uma classe DTO (DATA TRANSFER OBJECT)
public class RequisicaoNovoProfessor {

    @NotBlank
    @NotNull
    private String nome; // em caso de erro, NotBlank, requisicaoNovoProfessor.nome
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal salario;
    private EStatusProfessor statusProfessor;


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

    public Professor toProfessor(){
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);

        return professor;
    }

    @Override
    public String toString() {
        return "RequisicaoNovoProfessor{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                ", statusProfessor=" + statusProfessor +
                '}';
    }
}
