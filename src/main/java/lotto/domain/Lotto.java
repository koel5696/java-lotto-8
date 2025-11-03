package lotto.domain;

import static lotto.constants.LottoCondition.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoCondition.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoCondition.LOTTO_NUMBER_MIN;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoDTO;

public class Lotto {
    private static final String LOTTO_COUNT_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되면 안됩니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateUnique(numbers);
        for (Integer number : numbers) {
            validRange(number);
        }
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validRange(int number) {
        if (number < LOTTO_NUMBER_MIN.getValue() || number > LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.number());
    }

    public int countMatches(Lotto winLotto) {
        return (int) this.numbers.stream()
                .filter(winLotto.numbers::contains)
                .count();
    }

    public LottoDTO toLottoDto() {
        return new LottoDTO(this.numbers);
    }

}
