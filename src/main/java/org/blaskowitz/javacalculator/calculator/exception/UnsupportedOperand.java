package org.blaskowitz.javacalculator.calculator.exception;

public class UnsupportedOperand extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Неверный формат операнда";

    public UnsupportedOperand(String message) {
        super(message);
    }
    public UnsupportedOperand() {
        super(DEFAULT_MESSAGE);
    }
}