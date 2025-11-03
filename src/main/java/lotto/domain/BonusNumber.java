package lotto.domain;

import static lotto.constants.LottoCondition.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoCondition.LOTTO_NUMBER_MIN;

public record BonusNumber(int number) {
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이의 정수여야 합니다";

    public BonusNumber {
        if (number < LOTTO_NUMBER_MIN.getValue() || number > LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
