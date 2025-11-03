package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import lotto.dto.LottoDTO;
import lotto.dto.LottoResultDTO;
import lotto.util.randomNumber.RandomLottoExtraction;

public class LottoService {

    public Lottos generateLottosService(LottoPrice lottoPrice) {
        int count = lottoPrice.lottoCount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(RandomLottoExtraction.randomLottoExtraction()));
        }
        return new Lottos(lottos);
    }

    public LottoResult DrawALottoService(Lottos lottos, WinLotto winLotto) {
        Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
        Map<Rank, Integer> winningResults = lottos.lottosCompare(winLotto);
        lottoResult.putAll(winningResults);

        return new LottoResult(lottoResult);
    }

    public List<LottoDTO> generateResult(Lottos lottos) {
        return lottos.getLottosDTO();
    }

    public LottoResultDTO profitCalculatorService(LottoResult lottoResult, LottoPrice lottoPrice) {
        double total = lottoResult.calculateTotalPrize();
        return lottoResult.toResultDto(lottoPrice.profit(total));
    }

}
