package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private final List<Integer> winCounts;

    public LottoStatistics() {
        winCounts = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void addWinCount(int rank) {
        if (rank < 0) {
            return;
        }
        winCounts.set(rank, winCounts.get(rank) + 1);
    }

}
