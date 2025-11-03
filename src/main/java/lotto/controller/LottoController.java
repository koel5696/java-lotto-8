package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinLotto;
import lotto.dto.LottoResultDTO;
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
        LottoPrice lottoPrice = generatePrice();
        Lottos lottos = lottoService.generateLottosService(lottoPrice);
        outputView.lottoNumbersOutput(lottoService.generateResult(lottos));

        WinLotto winLotto = generateWinLotto();
        LottoResult lottoResult = lottoService.DrawALottoService(lottos, winLotto);

        LottoResultDTO lottoResultDTO = lottoService.profitCalculatorService(lottoResult, lottoPrice);
        outputView.lottoResultOutput(lottoResultDTO);
        outputView.profitOutput(lottoResultDTO);
    }

    private LottoPrice generatePrice() {
        String priceInput = inputView.LottoAmountInput();
        try {
            return new LottoPrice(NumberInputValidator.numberInputValidator(priceInput));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return generatePrice();
        }
    }

    private WinLotto generateWinLotto() {
        Lotto lotto = defaultWinLottoGenerate();
        return bonusNumberGenerate(lotto);
    }

    private Lotto defaultWinLottoGenerate() {
        String lottoInput = inputView.LottoNumberInput();
        try {
            return new Lotto(LottoInputValidator.lottoNumberInputValidator(lottoInput));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return defaultWinLottoGenerate();
        }
    }

    private WinLotto bonusNumberGenerate(Lotto lotto) {
        String bonusInput = inputView.LottoBonusNumberInput();
        try {
            BonusNumber bonusNumber = new BonusNumber(NumberInputValidator.numberInputValidator(bonusInput));
            return new WinLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return bonusNumberGenerate(lotto);
        }
    }

}
