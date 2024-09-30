package org.blaskowitz.javacalculator.calculator.exception;

public class UnsupportedOperationFormat extends RuntimeException {
    private static final String defaultMessage = "Формат операции не поддерживается";

    public UnsupportedOperationFormat(String message) {
        super(message);
    }
    public UnsupportedOperationFormat() {
        super(defaultMessage);
    }
}
