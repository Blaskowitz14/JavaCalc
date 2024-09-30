package org.blaskowitz.javacalculator.calculator;

import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperator;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    DIVISION("/"),
    MULTIPLICATION("*");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    private String getOperator() {
        return operator;
    }
    
    public static Operator getKey(String value) {
        for(Operator element : Operator.values()) {
            if (element.getOperator().equals(value)) {
                return element;
            }
        }
        throw new UnsupportedOperator();
    }
}