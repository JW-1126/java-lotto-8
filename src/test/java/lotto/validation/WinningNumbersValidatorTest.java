package lotto.validation;

import static lotto.exception.ErrorCode.DUPLICATED_NUMBER;
import static lotto.exception.ErrorCode.WRONG_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    WinningNumbersValidator validator = new WinningNumbersValidator();

    @ParameterizedTest
    @DisplayName("당첨 번호의 갯수가 6개가 아닌 경우에 대해 예외를 발생시킨다.")
    @ValueSource(strings = {"1,2,3,4"})
    void checkNumberCount_WrongCountInput_ThrowsException(String input) {
        //then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WRONG_NUMBER_COUNT.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호가 중복되는 경우에 대해 예외를 발생시킨다.")
    @ValueSource(strings = {"1,1,2,3,4,5"})
    void checkDuplicate_DuplicatedInput_ThrowsException(String input) {
        //then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBER.getErrorMessage());
    }

}