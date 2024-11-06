package com.example.calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testSumaDosOperandos() {
        Calculator calc = new Calculator();
        double resultado = calc.calculate("5+3");
        assertEquals("5 + 3 debe ser 8", 8, resultado, 0.001);
    }

    @Test
    public void testSumaMultiplesOperandos() {
        Calculator calc = new Calculator();
        double resultado = calc.calculate("4+3+1");
        assertEquals("4 + 3 + 1 debe ser 8", 8, resultado, 0.001);
    }

    @Test
    public void testMultiplicaDosOperandos() {
        Calculator calc = new Calculator();
        double resultado = calc.calculate("4*2");
        assertEquals("4 * 2 debe ser 8", 8, resultado, 0.001);
    }

    @Test
    public void testMultiplesOperaciones() {
        Calculator calc = new Calculator();
        double resultado = calc.calculate("2*3+4");
        assertEquals("2 * 3 + 4 debe ser 10", 10, resultado, 0.001);
    }

    @Test
    public void testOrdenOperaciones() {
        Calculator calc = new Calculator();
        double resultado = calc.calculate("3+2*2");
        assertEquals("3 + 2 * 2 debe ser 7", 7, resultado, 0.001);
    }

    @Test
    public void testExpresionCompleja() {
        Calculator calc = new Calculator();
        double resultado = calc.calculate("3+2*2+4");
        assertEquals("3 + 2 * 2 + 4 debe ser 11", 11, resultado, 0.001);
    }
}