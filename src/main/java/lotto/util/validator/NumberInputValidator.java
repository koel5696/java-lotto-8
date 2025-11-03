package lotto.util.validator;

import java.math.BigInteger;

public class NumberInputValidator {
    private static final String NUMBER_INPUT_PATTERN = "^[1-9]\\d*$";
    private static final String INPUT_EMPTY_ERROR_MESSAGE = "[ERROR] 빈(공백) 값이 들어왔습니다.";
    private static final String INPUT_FORMAT_ERROR_MESSAGE = "[ERROR] 0으로 시작하지 않는 자연수만 입력할 수 있습니다.";
    private static final String INPUT_OVERFLOW_ERROR_MESSAGE = "[ERROR] 입력이 비정상적으로 큽니다.";


    private NumberInputValidator() {
    }

    public static int numberInputValidator(String numberInput) {
        emptyValidate(numberInput);
        formatValidate(numberInput);
        overflowValidate(numberInput);
        return Integer.parseInt(numberInput);
    }

    private static void emptyValidate(String numberInput) {
        if (numberInput == null || numberInput.isBlank()) {
            throw new IllegalArgumentException(INPUT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static void formatValidate(String numberInput) {
        if (!numberInput.matches(NUMBER_INPUT_PATTERN)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void overflowValidate(String numberInput) {
        BigInteger numberInputAmount = new BigInteger(numberInput);
        BigInteger MaxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        if (numberInputAmount.compareTo(MaxInt) > 0) {
            throw new IllegalArgumentException(INPUT_OVERFLOW_ERROR_MESSAGE);
        }
    }
}
