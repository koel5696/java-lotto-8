package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import lotto.dto.LottoResultDTO;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult(Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public double calculateTotalPrize() {
        double total = 0.0;
        for (Rank rank : lottoResult.keySet()) {
            int prize = rank.getPrize();
            int count = lottoResult.get(rank);
            total += prize * count;
        }
        return total;
    }

    public LottoResultDTO toResultDto(double profit) {
        return new LottoResultDTO(
                Collections.unmodifiableMap(new EnumMap<>(lottoResult)), profit
        );
    }
}
