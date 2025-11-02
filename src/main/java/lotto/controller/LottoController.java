package lotto.controller;

import static lotto.controller.InputType.BONUS_NUMBER;
import static lotto.controller.InputType.PURCHASE_MONEY;
import static lotto.controller.InputType.WINNING_NUMBERS;
import static lotto.util.Parser.inputToDivide;
import static lotto.util.Parser.wordToNumbers;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPurchaseMoney;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printAll;
import static lotto.view.OutputView.printError;
import static lotto.view.OutputView.printLottosHeader;
import static lotto.view.OutputView.printProfit;
import static lotto.view.OutputView.printResultHeader;

import java.util.List;
import lotto.service.LottoService;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchaseInputValidator;
import lotto.validation.ValidateStrategy;
import lotto.validation.WinningNumbersValidator;

public class LottoController {

    private final LottoService lottoService;
    private final int UNIT_AMOUNT = 1000;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {

        int purchaseMoney = getPurchaseMoney();
        int purchaseQuantity = purchaseMoney / UNIT_AMOUNT;
        lottoService.createLotto(purchaseQuantity);
        printLottos(purchaseQuantity);

        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber();
        lottoService.recordStatistic(winningNumbers, bonusNumber);
        double profit = lottoService.calculateProfit(purchaseMoney);
        printResult(profit);
    }

    private static int getPurchaseMoney() {
        String purchaseMoneyInput = checkInput(PURCHASE_MONEY, new PurchaseInputValidator());
        return Integer.parseInt(purchaseMoneyInput);
    }

    private static List<Integer> getWinningNumbers() {
        String winningNumbersInput = checkInput(WINNING_NUMBERS, new WinningNumbersValidator());
        return wordToNumbers(inputToDivide(winningNumbersInput));
    }

    private static Integer getBonusNumber() {
        String bonusNumberInput = checkInput(BONUS_NUMBER, new BonusNumberValidator());
        return Integer.parseInt(bonusNumberInput);
    }

    private void printLottos(int purchaseQuantity) {
        printLottosHeader(purchaseQuantity);
        printAll(lottoService.getLottoNumbers());
    }

    private void printResult(double profit) {
        printResultHeader();
        printAll(lottoService.gameResult());
        printProfit(profit);
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
            printError(e);
            return false;
        }
    }

}
