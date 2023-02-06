package br.com.alura.tdd.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

    public String nome;
    public LocalDate dataAdmissao;
    public BigDecimal salario;

    public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void reajustarSalario(BigDecimal reajuste) {
        this.salario = this.salario.add(reajuste);
        arredondarSalario();
    }

    private void arredondarSalario() {
        this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
    }
}
