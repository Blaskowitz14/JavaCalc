package org.blaskowitz.javacalculator.calculator;

public enum OperandSystem {
    ARABIC, ROMAN;

    public static OperandSystem getSystem(String operand) {
        try {
            Double.parseDouble(operand);
            return OperandSystem.ARABIC;
        }
        catch (Exception exception) {
            return OperandSystem.ROMAN;
        }
    }
}
