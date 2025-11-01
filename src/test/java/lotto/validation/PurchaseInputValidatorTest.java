package lotto.validation;

import static lotto.exception.ErrorCode.NOT_DIVIDED_BY_THOUSAND;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseInputValidatorTest {

    PurchaseInputValidator validator = new PurchaseInputValidator();

    @ParameterizedTest
    @DisplayName("1000의 배수가 아닌 구입 구매 입력에 대해 예외를 발생시킨다.")
    @ValueSource(strings = {"12345", "132"})
    void checkDivided_EmptyInput_ThrowsException(String input) {
        //then
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVIDED_BY_THOUSAND.getErrorMessage());
    }
}