package lotto.controller;

import static lotto.controller.InputType.PURCHASE_MONEY;
import static lotto.controller.InputType.WINNING_NUMBERS;
import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPurchaseMoney;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printError;

import lotto.validation.ValidateStrategy;

public class InputHandler {
    public static String getValidatedInput(InputType inputType, ValidateStrategy strategy) {
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
