package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;

public record LottoResultDTO(
        Map<Rank, Integer> lottoResult,
        double profit
) {
}

