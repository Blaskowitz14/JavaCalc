package org.blaskowitz.javacalculator.calculator.exception;

public class UnsupportedOperationFormat extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Формат операции не поддерживается";

    public UnsupportedOperationFormat(String message) {
        super(message);
    }
    public UnsupportedOperationFormat() {
        super(DEFAULT_MESSAGE);
    }
}
