package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Rank;

public record LottoResultDTO(
        Map<Rank, Integer> lottoResult
) {
}

