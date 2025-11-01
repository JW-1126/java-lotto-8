package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumber implements NumberStrategy {
    public static final int LOTTO_NUM_RANGE_MAX = 45;
    public static final int LOTTO_NUM_RANGE_MIN = 1;
    public static final int LOTTO_NUM_QUANTITY = 6;

    @Override
    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUM_RANGE_MIN, LOTTO_NUM_RANGE_MAX, LOTTO_NUM_QUANTITY);
    }
}
