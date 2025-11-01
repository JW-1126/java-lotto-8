package lotto.exception;

public enum ErrorCode {
    ERROR_HEAD("[ERROR] "),
    EMPTY_INPUT("공백 입력은 허용되지 않습니다."),
    NO_INTEGER("입력값은 정수만 허용됩니다."),
    DIVIDED_BY_THOUSAND("구입 금액은 1000원 단위로만 입력 가능합니다."),
    WRONG_ARRANGE("당첨/보너스 번호는 1에서 45사이의 정수만 입력 가능합니다."),
    DUPLICATED_NUMBER("당첨 번호는 중복되지않아야 합니다."),
    WRONG_NUMBER_COUNT("당첨 번호는 6개의 정수여야 합니다.");

    private final String errorMessage;

    private ErrorCode(String message) {
        errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
