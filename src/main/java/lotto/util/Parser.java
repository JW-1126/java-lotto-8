package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> inputParser(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}
