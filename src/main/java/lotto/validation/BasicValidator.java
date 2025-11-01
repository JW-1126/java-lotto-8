package lotto.validation;

import static lotto.exception.ErrorCode.EMPTY_INPUT;
import static lotto.exception.ErrorCode.NO_POSITIVE_INTEGER;
import static lotto.exception.ErrorCode.OUT_OF_INTEGER_RANGE;
import static lotto.exception.ErrorCode.OUT_OF_NUMBER_RANGE;

import java.math.BigInteger;

public abstract class BasicValidator implements ValidateStrategy {
    public static final int LOTTO_NUM_RANGE_MAX = 45;

    @Override
    public void validate(String input) {
        checkBlank(input);
        checkPositiveNumber(input);
        checkNumberRange(input);
    }

    private static void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getErrorMessage());
        }
    }

    private static void checkPositiveNumber(String input) {
        if (!input.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException(NO_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private static void checkNumberRange(String input) {
        if (new BigInteger(input).compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(OUT_OF_INTEGER_RANGE.getErrorMessage());
        }
    }

    void checkGameNumberRange(int input) {
        if (input > LOTTO_NUM_RANGE_MAX) {
            throw new IllegalArgumentException(OUT_OF_NUMBER_RANGE.getErrorMessage());
        }
    }

}
