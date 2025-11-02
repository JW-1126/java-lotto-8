package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Collection> method() {
        return Stream.of(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @DisplayName("매개변수로 넘어온 리스트와 중복되는 요소의 수를 인덱스로 계산하여 반환한다.")
    @MethodSource("method")
    void matchLottos_CheckInput_ReturnDuplicateCount(List<Integer> numbers) {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThat(lotto.matchLottos(numbers, 0)).isEqualTo(4);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
