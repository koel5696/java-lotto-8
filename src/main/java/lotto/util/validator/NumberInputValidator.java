package lotto.util.validator;

import java.math.BigInteger;

public class NumberInputValidator {
    private static final String NUMBER_INPUT_PATTERN = "^\\d*$";

    private NumberInputValidator() {
    }

    public static int numberInputValidator(String numberInput) {
        emptyValidate(numberInput);
        formatValidate(numberInput);
        zeroStartValidate(numberInput);
        overflowValidate(numberInput);
        return Integer.parseInt(numberInput);
    }

    private static void emptyValidate(String numberInput) {
        if (numberInput == null || numberInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈(공백) 값이 들어 왔습니다.");
        }
    }

    private static void formatValidate(String numberInput) {
        if (!numberInput.matches(NUMBER_INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 자연수로 입력해주세요.");
        }
    }

    private static void zeroStartValidate(String numberInput) {
        if (numberInput.charAt(0) == '0' && numberInput.length() > 1) {
            throw new IllegalArgumentException("[ERROR] 자연수 입력은 0으로 시작할 수 없습니다.");
        }
    }

    private static void overflowValidate(String numberInput) {
        BigInteger numberInputAmount = new BigInteger(numberInput);
        BigInteger MaxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        if (numberInputAmount.compareTo(MaxInt) > 0) {
            throw new IllegalArgumentException("[ERROR] 입력이 비정상적으로 큽니다.");
        }
    }
}
