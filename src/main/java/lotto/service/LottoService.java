package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import lotto.domain.dto.LottoDTO;
import lotto.domain.dto.LottoResultDTO;

public class LottoService {

    public Lottos generateLottoService(LottoPrice lottoPrice) {
        return new Lottos(lottoPrice);
    }

    public LottoResultDTO DrawALottoService(Lottos lottos, WinLotto winLotto) {
        Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
        Map<Rank, Integer> winningResults = lottos.lottosCompare(winLotto);
        lottoResult.putAll(winningResults);

        return lottos.toLottoResultDTO(lottoResult);
    }

    public List<LottoDTO> generateResult(Lottos lottos) {
        return lottos.getLottosDTO();
    }

    public double profitCalculatorService(LottoResultDTO lottoResultDTO, LottoPrice lottoPrice) {
        int price = lottoPrice.lottoCount() * 1000;
        double total = 0.0;
        Map<Rank, Integer> lottoResult = lottoResultDTO.lottoResult();
        for (Rank rank : lottoResult.keySet()) {
            int prize = rank.getPrize();
            int count = lottoResult.get(rank);
            total += prize * count;
        }
        double profit = (total / price) * 100;
        return Math.round(profit * 10) / 10.0;
    }


}
