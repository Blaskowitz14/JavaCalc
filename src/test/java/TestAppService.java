import org.blaskowitz.javacalculator.calculator.AppService;
import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperand;
import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperationFormat;
import org.blaskowitz.javacalculator.calculator.exception.UnsupportedOperator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestAppService {
    private AppService service = new AppService();
    @Test
    public void ArabNumbersPlus_CorrectAnswer() {
        String testValue = "10 + 10";
        Assertions.assertEquals("20", service.handleUserInput(testValue));
    }
    @Test
    public void RomanNumbersMinus_CorrectAnswer() {
        String testValue = "X - ii";
        Assertions.assertEquals("VIII", service.handleUserInput(testValue));
    }
    @Test
    public void RomanNumbersDivision_CorrectAnswer() {
        String testValue = "Viii / ii";
        Assertions.assertEquals("IV", service.handleUserInput(testValue));
    }
    @Test
    public void RomanNumbersMultiplication_CorrectAnswer() {
        String testValue = "X * X";
        Assertions.assertEquals("C", service.handleUserInput(testValue));
    }

    @Test
    public void RomanNumbersPlus_CorrectAnswer() {
        String testValue = "X + x";
        Assertions.assertEquals("XX", service.handleUserInput(testValue));
    }

    @Test
    public void unknownOperator_ThrowsException() {
        String testValue = "x ( x";
        UnsupportedOperator thrown = Assertions.assertThrows(UnsupportedOperator.class, () -> {
            service.handleUserInput(testValue);
        });
    }
    @Test
    public void nonExistentRomanNumber_ThrowsException() {
        String testValue = "ZZZZZ + VVVVV";
        UnsupportedOperand thrown = Assertions.assertThrows(UnsupportedOperand.class, () -> {
            service.handleUserInput(testValue);
        });
    }
    @Test
    public void operandsSystemsNotEqual_ThrowsException() {
        String testValue = "9 + X";
        UnsupportedOperand thrown = Assertions.assertThrows(UnsupportedOperand.class, () -> {
            service.handleUserInput(testValue);
        });
    }
    @Test
    public void unexpectedOperandsSize_ThrowException() {
        String testValue = "XII + C";
        UnsupportedOperand thrown = Assertions.assertThrows(UnsupportedOperand.class, () -> {
            service.handleUserInput(testValue);
        });
    }
    @Test
    public void wrongInputFormat_ThrowException() {
        String testValue = "x + x + x";
        UnsupportedOperationFormat thrown = Assertions.assertThrows(UnsupportedOperationFormat.class, () -> {
            service.handleUserInput(testValue);
        });
    }
    @Test
    public void divisionByZero_ThrowException() {
        String testValue = "2 / 0";
        ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> {
            service.handleUserInput(testValue);
        });
    }

}
