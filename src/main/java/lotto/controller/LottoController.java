package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.WinLotto;
import lotto.domain.dto.LottoResultDTO;
import lotto.service.LottoService;
import lotto.util.validator.LottoInputValidator;
import lotto.util.validator.NumberInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoPrice lottoPrice = priceValidation();
        Lottos lottos = lottoService.generateLottoService(lottoPrice);
        outputView.lottoNumbersOutput(lottoService.generateResult(lottos));

        Lotto lotto = lottoValidation();
        WinLotto winLotto = bonusNumberValidation(lotto);
        LottoResultDTO lottoResultDTO = lottoService.DrawALottoService(lottos, winLotto);
        double profit = lottoService.profitCalculatorService(lottoResultDTO, lottoPrice);
        outputView.lottoResultOutput(lottoResultDTO);
        outputView.profitOutput(profit);
    }

    private LottoPrice priceValidation() {
        String priceInput = inputView.LottoAmountInput();
        try {
            return new LottoPrice(NumberInputValidator.numberInputValidator(priceInput));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return priceValidation();
        }
    }

    private Lotto lottoValidation() {
        String lottoInput = inputView.LottoNumberInput();
        try {
            return new Lotto(LottoInputValidator.lottoNumberInputValidator(lottoInput));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoValidation();
        }
    }

    private WinLotto bonusNumberValidation(Lotto lotto) {
        String bonusNumberInput = inputView.LottoBonusNumberInput();
        try {
            int bonus = NumberInputValidator.numberInputValidator(bonusNumberInput);
            BonusNumber bonusNumber = new BonusNumber(bonus);
            return new WinLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumberValidation(lotto);
        }
    }

}
