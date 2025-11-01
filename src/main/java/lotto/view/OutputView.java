package lotto.view;

import static lotto.exception.ErrorCode.ERROR_HEAD;

import lotto.exception.ErrorCode;

public class OutputView {

    public void printError(ErrorCode errorCode) {
        System.out.println(ERROR_HEAD + errorCode.getErrorMessage());
    }
}
