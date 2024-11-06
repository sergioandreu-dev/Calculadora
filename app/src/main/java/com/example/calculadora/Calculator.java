package com.example.calculadora;

/**
 * La clase Calculator realiza operaciones aritméticas basicas.
 * @author Sergio Andreu
 * @version 1.0
 * @since 2024
 */
public class Calculator {

    /**
     * Realiza el cálculo de la expresión aritmética dada en formato String.
     *
     * @param expresion la expresión aritmética en formato String
     * @return el resultado de la expresión aritmética
     * @throws NumberFormatException si la expresión no es válida
     */
    public double calculate(String expresion) throws NumberFormatException {
        expresion = expresion.replaceAll("\\s", "");

        for (int i = expresion.length() - 1; i >= 0; i--) {
            char c = expresion.charAt(i);
            if (c == '+' || c == '-') {
                double left = calculate(expresion.substring(0, i));
                double right = calculate(expresion.substring(i + 1));
                return c == '+' ? left + right : left - right;
            }
        }

        for (int i = expresion.length() - 1; i >= 0; i--) {
            char c = expresion.charAt(i);
            if (c == '*' || c == '/') {
                double left = calculate(expresion.substring(0, i));
                double right = calculate(expresion.substring(i + 1));
                return c == '*' ? left * right : left / right;
            }
        }
        return Double.parseDouble(expresion);
    }
}
