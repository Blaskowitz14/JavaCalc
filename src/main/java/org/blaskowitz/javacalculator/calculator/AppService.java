package org.blaskowitz.javacalculator.calculator;

import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperator;

public class AppService {
    public String handleUserInput(String userInput) {
        String[] formattedInput = userInput.toUpperCase().split(" ");
        OperandSystem system = Validator.validateData(formattedInput);
        formattedInput = Converter.convertOperands(formattedInput, system);
        return switch (system) {
            case ARABIC -> executeCalculation(formattedInput).toString();
            case ROMAN -> Converter.convertArabicNumber(executeCalculation(formattedInput));
        };
    }
    private Integer executeCalculation(String[] processedInput) {
        String leftOperand = processedInput[0];
        Operator operator = Operator.getKey(processedInput[1]);
        String rightOperand = processedInput[2];
        return switch (operator) {
            case PLUS -> Calculator.add(leftOperand, rightOperand);
            case MINUS -> Calculator.subtract(leftOperand, rightOperand);
            case DIVISION -> Calculator.divide(leftOperand, rightOperand);
            case MULTIPLICATION -> Calculator.multiply(leftOperand, rightOperand);
            default -> throw new UnsupportedOperator();
        };


    }

}
