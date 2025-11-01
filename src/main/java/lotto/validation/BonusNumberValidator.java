package lotto.validation;

public class BonusNumberValidator extends BasicValidator {
    @Override
    public void validate(String input) {
        super.validate(input);
        super.checkGameNumberRange(Integer.parseInt(input));
    }
}
