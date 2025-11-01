package lotto.controller;

import static lotto.controller.InputType.BONUS_NUMBER;
import static lotto.controller.InputType.PURCHASE_MONEY;
import static lotto.controller.InputType.WINNING_NUMBERS;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPurchaseMoney;
import static lotto.view.InputView.inputWinningNumbers;

import lotto.service.LottoService;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchaseInputValidator;
import lotto.validation.ValidateStrategy;
import lotto.validation.WinningNumbersValidator;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {

        String purchaseMoney = checkInput(PURCHASE_MONEY, new PurchaseInputValidator());

        //로또 생성
        lottoService.createLotto(Integer.parseInt(purchaseMoney));

        //로또 출력

        //당첨 & 보너스 번호 입력
        String winningNumbers = checkInput(WINNING_NUMBERS, new WinningNumbersValidator());

        String bonusNumber = checkInput(BONUS_NUMBER, new BonusNumberValidator());

        //당첨 통계 계산 & 출력
    }

    private static String checkInput(InputType inputType, ValidateStrategy strategy) {
        String input;
        do {
            input = callInput(inputType);
        } while (!isValidated(input, strategy));

        return input;
    }

    private static String callInput(InputType inputType) {
        if (inputType == PURCHASE_MONEY) {
            return inputPurchaseMoney();
        }
        if (inputType == WINNING_NUMBERS) {
            return inputWinningNumbers();
        }
        if (inputType == InputType.BONUS_NUMBER) {
            return inputBonusNumber();
        }
        return null;
    }

    private static boolean isValidated(String input, ValidateStrategy strategy) {
        try {
            strategy.validate(input);
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return false;
        }
    }

}
