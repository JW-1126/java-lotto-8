package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> inputToDivide(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    public static List<Integer> wordToNumbers(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
