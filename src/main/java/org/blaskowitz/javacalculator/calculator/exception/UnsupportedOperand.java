package org.blaskowitz.javacalculator.calculator.exception;

public class UnsupportedOperand extends RuntimeException {
    private static final String defaultMessage = "Неверный формат операнда";

    public UnsupportedOperand(String message) {
        super(message);
    }
    public UnsupportedOperand() {
        super(defaultMessage);
    }
}