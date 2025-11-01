package lotto.validation;

import static lotto.exception.ErrorCode.NOT_DIVIDED_BY_THOUSAND;

public class PurchaseInputValidator extends BasicValidator {
    @Override
    public void validate(String input) {
        super.validate(input);
        checkDivided(input);
    }

    private static void checkDivided(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_THOUSAND.getErrorMessage());
        }
    }
}
