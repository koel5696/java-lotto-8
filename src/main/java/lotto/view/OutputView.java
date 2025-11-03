package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;
import lotto.dto.LottoDTO;
import lotto.dto.LottoResultDTO;

public class OutputView {

    private enum Message {
        NEW_LINE("\n"),
        BUY_COUNT_GUIDE("개를 구매했습니다."),
        STATISTICS_HEADER("\n당첨 통계\n---"),
        PRIZE_COUNT("개"),
        TOTAL_PROFIT("총 수익률은 "),
        PROFIT_SUFFIX("%입니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String get() {
            return message;
        }
    }

    public void lottoNumbersOutput(List<LottoDTO> lottoDTOS) {
        System.out.println(Message.NEW_LINE.get() + lottoDTOS.size() + Message.BUY_COUNT_GUIDE.get());
        lottoDTOS.forEach(lottoDTO -> System.out.println(lottoDTO.toString()));
    }

    public void lottoResultOutput(LottoResultDTO lottoResultDTO) {
        System.out.println(Message.STATISTICS_HEADER.get());
        Map<Rank, Integer> lottoResult = lottoResultDTO.lottoResult();

        for (Rank rank : lottoResult.keySet()) {
            int count = lottoResult.get(rank);
            System.out.println(rank.getCorrespond() + count + Message.PRIZE_COUNT.get());
        }
    }

    public void profitOutput(LottoResultDTO lottoResultDTO) {
        System.out.println(Message.TOTAL_PROFIT.get() + lottoResultDTO.profit() + Message.PROFIT_SUFFIX.get());
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
