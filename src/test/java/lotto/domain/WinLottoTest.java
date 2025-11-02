package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinLottoTest {
    private static List<Integer> numbers;

    @Test
    void 당첨_번호가_정상적으로_생성된다() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> new WinLotto(new Lotto(numbers), new BonusNumber(10)))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new WinLotto(new Lotto(numbers), new BonusNumber(2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 기본 당첨 번호와 중복될 수 없습니다.");
    }
}
