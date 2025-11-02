package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.dto.LottoDTO;
import lotto.domain.dto.LottoResultDTO;
import lotto.util.randomNumber.RandomLottoExtraction;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(LottoPrice lottoPrice) {
        this.lottos = Stream.generate(() -> new Lotto(RandomLottoExtraction.randomLottoExtraction()))
                .limit(lottoPrice.lottoCount())
                .toList();
    }

    public Map<Rank, Integer> lottosCompare(WinLotto winLotto) {
        return lottos.stream()
                .map(winLotto::judgeWin)
                .flatMap(Optional::stream)
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 1,
                        Integer::sum
                ));
    }

    public List<LottoDTO> getLottosDTO() {
        return lottos.stream()
                .map(Lotto::toDto)
                .toList();
    }

    public LottoResultDTO toLottoResultDTO(Map<Rank, Integer> lottoResult) {
        return new LottoResultDTO(lottoResult);
    }

}
