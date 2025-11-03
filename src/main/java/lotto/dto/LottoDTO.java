package lotto.dto;

import java.util.List;

public record LottoDTO(List<Integer> numbers) {

    public LottoDTO(List<Integer> numbers) {
        this.numbers = List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
