package lotto.view;

import static lotto.exception.ErrorCode.ERROR_HEAD;

import java.util.List;

public class OutputView {

    public static void printError(IllegalArgumentException e) {
        System.out.println(ERROR_HEAD.getErrorMessage() + e.getMessage());
    }

    public static void printLottosHeader(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printAllLottos(List<String> lottos) {
        lottos.forEach(System.out::println);
    }
}
