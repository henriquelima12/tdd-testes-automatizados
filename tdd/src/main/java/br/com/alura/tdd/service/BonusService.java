package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Funcionario;

import java.math.BigDecimal;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if(valor.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException("Funcionário com salário maior que R$ 10.000,00 não pode receber bonificação");
        }
        return valor;
    }

}
