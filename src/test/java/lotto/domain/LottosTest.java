package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {
    private static final int FOUR = 3;

    @Test
    void 로또_랜덤_번호가_정상적으로_생성된다() {
        assertRandomNumberInRangeTest(() -> {
                Lottos lottos = new Lottos(new LottoPrice(3000));

                Lotto expectedLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                Lotto expectedLotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
                Lotto expectedLotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));

                List<Lotto> actualLottos = lottos.copyLottos();

                assertThat(actualLottos).containsExactly(
                        expectedLotto1,
                        expectedLotto2,
                        expectedLotto3
                );

            }, 1, 2, 3, 4, 5, 6, // 1번 로또
            7, 8, 9, 10, 11, 12, // 2번 로또
            13, 14, 15, 16, 17, 18 // 3번 로또
        );
    }

    @Test
    void 로또_랜덤_번호가_초과되면_예외가_발생한다() {
        assertRandomNumberInRangeTest(() -> {
                    assertThatThrownBy(() -> new Lottos(new LottoPrice(1000))
                            .isInstanceOf(IllegalArgumentException.class);
                }, 1, 2, 3, 4, 5, 46);
    }

    @Test
    void 로또_번호_비교가_정상적으로_작동한다() {
        assertRandomNumberInRangeTest(() -> {
            List<Integer> lotto = Arrays.stream("1,2,3,4,5,6".split(","))
                    .map(Integer::parseInt)
                    .toList();
            Lottos lottos = new Lottos(new LottoPrice(1000));
            WinLotto winLotto = new WinLotto(new Lotto(lotto), new BonusNumber(10));
            LottoResultTest lottoResult = lottos.compare(winLotto.copyWinLotto());
            List<Integer> result = lottoResult.copyResult();
            assertThat(result.get(FOUR)).isEqualTo(1); // 4등이 1개
        }, 1, 2, 3, 4, 20, 30);
    }

}
