package org.blaskowitz.javacalculator.calculator.exception;

public class UnsupportedOperator extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Неверный формат оператора";

    public UnsupportedOperator(String message) {
        super(message);
    }
    public UnsupportedOperator() {
        super(DEFAULT_MESSAGE);
    }
}
