package lotto.view;

import java.util.List;

public class OutputView {

    public static void printError(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void printLottosHeader(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printResultHeader() {
        System.out.println("당첨 통계\n---");
    }

    public static void printAll(List<String> result) {
        result.forEach(System.out::println);
    }

}
