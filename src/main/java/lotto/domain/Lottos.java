package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
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
                .map(Lotto::toLottoDto)
                .toList();
    }

}
