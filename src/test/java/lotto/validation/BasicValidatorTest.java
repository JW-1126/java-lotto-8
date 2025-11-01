package lotto.validation;

import static lotto.exception.ErrorCode.EMPTY_INPUT;
import static lotto.exception.ErrorCode.NO_POSITIVE_INTEGER;
import static lotto.exception.ErrorCode.OUT_OF_INTEGER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BasicValidatorTest {

    BasicValidator validator = new BasicValidator() {
        @Override
        public void validate(String input) {
            super.validate(input);
        }
    };

    @ParameterizedTest
    @DisplayName("공백 입력에 대해 예외를 발생시킨다.")
    @EmptySource
    @ValueSource(strings = {" "})
    void validate_EmptyInput_ThrowsException(String input) {
        //then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_INPUT.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("양의 정수가 아닌 입력값에 대해 예외를 발생시킨다.")
    @CsvSource({"-15", "non integer", "0"})
    void validate_NonIntegerInput_ThrowsException(String input) {
        //then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NO_POSITIVE_INTEGER.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("정수 처리 가능 범위를 벗어난 입력값에 대해 예외를 발생시킨다.")
    @ValueSource(strings = {"99999999999999"})
    void validate_ExceedsIntegerRange_ThrowsException(String input) {
        //then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_INTEGER_RANGE.getErrorMessage());
    }

}