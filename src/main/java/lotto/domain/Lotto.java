package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.dto.LottoDTO;

public class Lotto {
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private void validRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수여야 합니다");
        }
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    public int countMatches(Lotto winLotto) {
        return (int) this.numbers.stream()
                .filter(winLotto.numbers::contains)
                .count();
    }

    public LottoDTO toDto() {
        return new LottoDTO(this.numbers);
    }

}
