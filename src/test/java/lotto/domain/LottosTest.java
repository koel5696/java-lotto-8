package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import lotto.domain.dto.LottoDTO;
import org.junit.jupiter.api.Test;

public class LottosTest {
    private static List<Integer> numbers;

    @Test
    void 로또_랜덤_번호가_정상적으로_생성된다() {

        assertRandomUniqueNumbersInRangeTest(() -> {
                    Lottos lottos = new Lottos(new LottoPrice(3000));

                    LottoDTO expectedDto1 = new LottoDTO(List.of(1, 2, 3, 4, 5, 6));
                    LottoDTO expectedDto2 = new LottoDTO(List.of(7, 8, 9, 10, 11, 12));
                    LottoDTO expectedDto3 = new LottoDTO(List.of(13, 14, 15, 16, 17, 18));

                    List<LottoDTO> lottoDTOS = lottos.getLottosDTO();
                    assertThat(lottoDTOS).containsExactly(
                            expectedDto1,
                            expectedDto2,
                            expectedDto3
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18)
        );
    }

    @Test
    void 로또_랜덤_번호가_초과되면_예외가_발생한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            assertThatThrownBy(() -> new Lottos(new LottoPrice(1000)))
                    .isInstanceOf(IllegalArgumentException.class);
        }, List.of(1, 2, 3, 4, 20, 46));
    }

    @Test
    void 로또_번호_비교가_정상적으로_작동한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            numbers = List.of(1, 2, 3, 4, 20, 30);
            Lottos lottos = new Lottos(new LottoPrice(1000));
            WinLotto winLotto = new WinLotto(new Lotto(numbers), new BonusNumber(10));
            Map<Rank, Integer> lottoResult = lottos.lottosCompare(winLotto);
            assertThat(lottoResult.get(Rank.FOUR)).isEqualTo(1); // 4등이 1개
        }, List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_당첨일_때_로또_번호_비교가_정상적으로_작동한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            numbers = List.of(1, 2, 3, 4, 5, 30);
            Lottos lottos = new Lottos(new LottoPrice(1000));
            WinLotto winLotto = new WinLotto(new Lotto(numbers), new BonusNumber(10));
            Map<Rank, Integer> lottoResult = lottos.lottosCompare(winLotto);
            assertThat(lottoResult.get(Rank.FIVE_BONUS)).isEqualTo(1); // 2등이 1개
        }, List.of(1, 2, 3, 4, 5, 10));
    }

}
