package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

    public int matchLottos(List<Integer> winningNum, int bonus) {
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
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

}
