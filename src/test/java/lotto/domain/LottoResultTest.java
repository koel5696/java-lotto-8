package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    void 수익률_계산이_정상적으로_작동한다() {
        assertRandomNumberInRangeTest(() -> {
            List<Integer> lotto = Arrays.stream("1,2,3,4,5,6".split(","))
                    .map(Integer::parseInt)
                    .toList();
            Lottos lottos = new Lottos(new LottoPrice(1000));
            WinLotto winLotto = new WinLotto(new lotto(lotto), new BonusNumber(10));
            LottoResultTest lottoResult = lottos.compare(winLotto.copyWinLotto());

            assertThat(lottoResult.profitRate()).isEqualTo(150000.0);
        }, 1, 2, 3, 4, 5, 30);
    }
}
