package lotto.validation;

import static lotto.exception.ErrorCode.DUPLICATED_NUMBER;
import static lotto.exception.ErrorCode.WRONG_NUMBER_COUNT;
import static lotto.util.Parser.inputParser;

import java.util.HashSet;
import java.util.List;

public class WinningNumbersValidator extends BasicValidator {

    public static final int NUMBER_COUNT = 6;

    @Override
    public void validate(String input) {
        List<String> parsed = inputParser(input);
        parsed.forEach(each -> {
            super.validate(each);
            int num = Integer.parseInt(each);
            super.checkGameNumberRange(num);
        });
        checkDuplicate(parsed);
        checkNumberCount(parsed);
    }

    private static void checkDuplicate(List<String> parsed) {
        if (new HashSet<>(parsed).size() != parsed.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getErrorMessage());
        }
    }

    private static void checkNumberCount(List<String> parsed) {
        if (parsed.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_NUMBER_COUNT.getErrorMessage());
        }
    }
}
