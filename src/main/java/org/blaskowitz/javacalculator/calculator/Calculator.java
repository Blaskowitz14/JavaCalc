package org.blaskowitz.javacalculator.calculator;

public class Calculator {
    public static Integer add(String leftOperand, String rightOperand) {
        return Integer.parseInt(leftOperand) + Integer.parseInt(rightOperand);
    }
    public static Integer subtract(String leftOperand, String rightOperand) {
        return Integer.parseInt(leftOperand) - Integer.parseInt(rightOperand);
    }
    public static Integer divide(String leftOperand, String rightOperand) {
        return Integer.parseInt(leftOperand) / Integer.parseInt(rightOperand);
    }
    public static Integer multiply(String leftOperand, String rightOperand) {
        return Integer.parseInt(leftOperand) * Integer.parseInt(rightOperand);
    }
}
