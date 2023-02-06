package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service;

    @BeforeEach
    public void inicializar() {
        service = new BonusService();
    }

    @Test
    public void shouldBeZeroWhenBonusGreaterThanThousand() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal(25000))));

        /*try {
            service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal(25000)));
            fail("Exception não foi lançada");
        } catch(Exception e) {
            assertEquals("Funcionário com salário maior que R$ 10.000,00 não pode receber bonificação", e.getMessage());
        }*/
    }

    @Test
    public void shouldBeTenPercentWhenBonusLessThanThousand() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Maria", LocalDate.now(), new BigDecimal(2500)));
        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void shouldBeTenPercentWhenBonusEqualsToThousand() {
        BigDecimal bonus = service.calcularBonus(new Funcionario("Antônio", LocalDate.now(), new BigDecimal(10000)));
        assertEquals(new BigDecimal("1000.0"), bonus);
    }

}