package lotto.util.randomNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RandomLottoExtraction {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;


    private RandomLottoExtraction() {
    }

    public static List<Integer> randomLottoExtraction() {
        List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER,
                LOTTO_NUMBER_COUNT);
        List<Integer> sortableLotto = new ArrayList<>(newLotto);
        Collections.sort(sortableLotto);
        return sortableLotto;
    }
}
