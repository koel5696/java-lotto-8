package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PRICE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBERS_INPUT_GUIDE_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBERS_INPUT_GUIDE_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String LottoAmountInput() {
        System.out.println(PRICE_INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }

    public String LottoNumberInput() {
        System.out.println(WIN_NUMBERS_INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }

    public String LottoBonusNumberInput() {
        System.out.println(BONUS_NUMBERS_INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }
}
