package lotto.util.validator;

import java.util.ArrayList;
import java.util.List;

public final class LottoInputValidator {
    private static final String LOTTO_NUMBERS_INPUT_PATTERN = "^\\d+(,\\d+)*$";

    private LottoInputValidator() {
    }

    public static List<Integer> lottoNumberInputValidator(String numberInput) {
        formatValidate(numberInput);
        String[] numbers = numberInput.split(",");
        List<Integer> numberList = new ArrayList<>();
        for (String number : numbers) {
            NumberInputValidator.numberInputValidator(number);
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }

    private static void formatValidate(String numberInput) {
        if (!numberInput.matches(LOTTO_NUMBERS_INPUT_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분하고, 빈 값 없이 자연수로 입력해야 합니다.");
        }
    }
}
