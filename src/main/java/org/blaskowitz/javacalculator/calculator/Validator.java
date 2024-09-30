package org.blaskowitz.javacalculator.calculator;
import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperand;
import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperationFormat;

public class Validator {
    public static OperandSystem validateData(String[] input) {
        checkQuantity(input);
        checkOperandSystemsEquality(input);
        return checkOperandsSize(input);
    }
    private static void checkQuantity(String[] input) {
        if(input.length != 3) {
            throw new UnsupportedOperationFormat();
        }
    }
    private static void checkOperandSystemsEquality(String[] input) {
        String leftOperand = input[0];
        String rightOperand = input[2];
        if (OperandSystem.getSystem(leftOperand) != OperandSystem.getSystem(rightOperand)) {
            throw new UnsupportedOperand("Системы счисления операндов не совпадают");
        }
    }
    private static OperandSystem checkOperandsSize(String[] input) {
        String leftOperand = input[0];
        String rightOperand = input[2];
        OperandSystem system = OperandSystem.getSystem(leftOperand);
        switch (system) {
            case ARABIC:
                if (Integer.parseInt(leftOperand) <= 10 && Integer.parseInt(rightOperand) <= 10) {
                    return system;
                }
            case ROMAN:
                if (Integer.parseInt(Converter.convertRomanNumber(leftOperand)) <= 10
                        && Integer.parseInt(Converter.convertRomanNumber(rightOperand)) <= 10) {
                    return system;
                }
        }
        throw new UnsupportedOperand();
    }
}
