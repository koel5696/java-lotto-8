package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @Test
    void 당첨_번호가_정상적으로_생성된다() {
        List<Integer> lotto = Arrays.stream("1,2,3,4,5,6".split(","))
                .map(Integer::parseInt)
                .toList();
        int inputBonus = 10;

        BonusNumber bonusNumber = new BonusNumber();
        assertThatCode(() -> new WinLotto(new Lotto(lotto), new BonusNumber(inputBonus))
                .doesNotThrowAnyException());
    }

    @Test
    void 보너스_번호가_이상하면_당첨_번호가_생성되지_않는다() {
        List<Integer> lotto = Arrays.stream("1,2,3,4,5,6".split(","))
                .map(Integer::parseInt)
                .toList();
        int inputBonus = -2;

        assertThatThrownBy(() -> new WinLotto(new Lotto(lotto), new BonusNumber(inputBonus)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_입력이_이상하면_당첨_번호가_생성되지_않는다() {
        List<Integer> lotto = Arrays.stream("1,2,3,4,5,6,7".split(","))
                .map(Integer::parseInt)
                .toList();
        int inputBonus = 10;

        assertThatThrownBy(() -> new WinLotto(new Lotto(lotto), new BonusNumber(inputBonus)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
