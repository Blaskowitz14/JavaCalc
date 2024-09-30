package org.blaskowitz.javacalculator.calculator.exception;

public class UnsupportedOperator extends RuntimeException {
    private static final String defaultMessage = "Неверный формат оператора";

    public UnsupportedOperator(String message) {
        super(message);
    }
    public UnsupportedOperator() {
        super(defaultMessage);
    }
}
