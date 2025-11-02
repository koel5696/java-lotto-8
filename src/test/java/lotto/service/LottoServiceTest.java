package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.WinLotto;
import lotto.domain.dto.LottoResultDTO;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private static final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    @Test
    void 수익률_계산이_정상적으로_작동한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoPrice lottoPrice = new LottoPrice(1000);
            Lottos lottos = new Lottos(lottoPrice);
            WinLotto winLotto = new WinLotto(new Lotto(numbers), new BonusNumber(10));
            LottoService lottoService = new LottoService();
            LottoResultDTO lottoResultDTO = lottoService.DrawALottoService(lottos, winLotto);

            assertThat(lottoService.profitCalculatorService(lottoResultDTO, lottoPrice)).isEqualTo(150000.0);
        }, List.of(1, 2, 3, 4, 5, 30));
    }
}
