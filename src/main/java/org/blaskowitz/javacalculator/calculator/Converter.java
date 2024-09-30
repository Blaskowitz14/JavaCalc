package org.blaskowitz.javacalculator.calculator;
import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperand;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Converter {

    private static final Map<String, Integer> ROMAN_NUMBERS_MAP = Map.of(
            "I", 1,
            "IV", 4,
            "V", 5,
            "IX", 9,
            "X", 10,
            "XL", 40,
            "L", 50,
            "XC", 90,
            "C", 100);

    public static String convertRomanNumber(String romanNumber) {
        romanNumber = romanNumber.toUpperCase();
        String[] romanNumbers = romanNumber.split("");
        int convertedNumber = 0;
        int selectedNumber;
        int previousNumber = 0;
        try {
            for (int i = romanNumbers.length - 1; i >= 0; i--) {
                selectedNumber = ROMAN_NUMBERS_MAP.get(romanNumbers[i]);
                if (selectedNumber > previousNumber) {
                    convertedNumber += selectedNumber;
                    previousNumber = selectedNumber;
                }
                else if (selectedNumber < previousNumber) {
                    convertedNumber -= selectedNumber;
                    previousNumber = selectedNumber;
                }
                else if (selectedNumber == previousNumber) {
                    convertedNumber += selectedNumber;
                }

            }
        }
        catch (NullPointerException exception) {
            throw new UnsupportedOperand();
        }

        return Integer.toString(convertedNumber);
    }
    public static String convertArabicNumber(int arabicNumber) {
        Map<Integer, String> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        sortedMap.putAll(swapKeysWithValues(ROMAN_NUMBERS_MAP));

        String convertedNumber = "";

        try {
            for (Integer element : sortedMap.keySet()) {
                while(arabicNumber >= element) {
                    convertedNumber += sortedMap.get(element);
                    arabicNumber -= element;
                }
            }
        } catch (NullPointerException e) {
            throw new UnsupportedOperand();
        }

        return convertedNumber;
    }
    public static String[] convertOperands(String[] input, OperandSystem system) {
        if (system == OperandSystem.ROMAN) {
            input[0] = convertRomanNumber(input[0]);
            input[2] = convertRomanNumber(input[2]);
        }
        return input;
    }
    private static Map<Integer, String> swapKeysWithValues(Map<String, Integer> inputMap) {
        Map<Integer, String> reversedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }
        return reversedMap;
    }
}
