package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    private static final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호는 1~45로 입력받아야 한다")
    @Test
    void 보너스_번호의_숫자가_이상하면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinLotto(new Lotto(numbers), new BonusNumber(46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1~45 사이의 정수여야 합니다");
    }
}
