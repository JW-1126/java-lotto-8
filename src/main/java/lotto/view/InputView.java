package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseMoney() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println("\n" + WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("\n" + BONUS_NUM_MESSAGE);
        return Console.readLine();
    }
}
