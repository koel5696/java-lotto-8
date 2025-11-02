package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.dto.LottoDTO;
import lotto.domain.dto.LottoResultDTO;

public class OutputView {

    public void lottoNumbersOutput(List<LottoDTO> lottoDTOS) {
        System.out.println("\n" + lottoDTOS.size() + "개를 구매했습니다.");
        lottoDTOS.forEach(lottoDTO -> System.out.println(lottoDTO.toString()));
    }

    public void lottoResultOutput(LottoResultDTO lottoResultDTO) {
        System.out.println("\n당첨 통계\n---");
        Map<Rank, Integer> lottoResult = lottoResultDTO.lottoResult();

        for (Rank rank : lottoResult.keySet()) {
            int count = lottoResult.get(rank);
            int prize = rank.getPrize();
            if (prize == 30_000_000) {
                System.out.println(
                        rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + String.format("%,d", prize) + "원) - " + count
                                + "개");
                continue;
            }
            System.out.println(rank.getMatchCount() + "개 일치 (" + String.format("%,d", prize) + "원) - " + count + "개");
        }
    }

    public void profitOutput(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
