package lotto.validation;

import static lotto.exception.ErrorCode.OUT_OF_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    BonusNumberValidator validator = new BonusNumberValidator();

    @ParameterizedTest
    @DisplayName("1~45 범위를 벗어난 입력값에 대해 예외를 발생시킨다.")
    @ValueSource(strings = {"56"})
    void checkGameNumberRange_ExceedsGameRuleRange_ThrowsException(String input) {
        //then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_NUMBER_RANGE.getErrorMessage());
    }

}