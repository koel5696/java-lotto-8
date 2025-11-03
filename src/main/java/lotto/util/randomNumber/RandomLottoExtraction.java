package lotto.util.randomNumber;

import static lotto.constants.LottoCondition.LOTTO_NUMBER_COUNT;
import static lotto.constants.LottoCondition.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoCondition.LOTTO_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RandomLottoExtraction {

    private RandomLottoExtraction() {
    }

    public static List<Integer> randomLottoExtraction() {
        List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(),
                LOTTO_NUMBER_MAX.getValue(), LOTTO_NUMBER_COUNT.getValue());
        List<Integer> sortableLotto = new ArrayList<>(newLotto);
        Collections.sort(sortableLotto);
        return sortableLotto;
    }
}
