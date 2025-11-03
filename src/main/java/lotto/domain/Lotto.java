package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야합니다.");
        }
    }

    //당첨 번호와 일치하는 갯수를 순위 리스트의 인덱스로 변환하여 반환한다. 5~1등 -> index 0~4
    public int matchLottoToWinNum(List<Integer> winningNum, int bonus) {
        int index = (int) numbers.stream()
                .filter(winningNum::contains)
                .count() - 3;
        if ((index == 2 && numbers.contains(bonus)) || index == 3) {
            index += 1;
        }
        return index;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
