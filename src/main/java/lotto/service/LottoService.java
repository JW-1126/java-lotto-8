package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Rank;
import lotto.domain.number.NumberStrategy;
import lotto.domain.number.RandomNumber;
import lotto.repository.Lottos;

public class LottoService {
    private final Lottos lottos;
    private final NumberStrategy strategy = new RandomNumber();
    private final LottoStatistics statistics = new LottoStatistics();

    public LottoService(Lottos lottos) {
        this.lottos = lottos;
    }

    public void createLotto(int quantity) {
        while (quantity > 0) {
            lottos.add(new Lotto(strategy.getNumbers()
                    .stream().sorted().toList()));
            quantity--;
        }
    }

    public List<String> getLottoNumbers() {
        return lottos.getLottos().stream()
                .map(Lotto::toString)
                .toList();
    }

    public void recordStatistic(List<Integer> numbers, int bonus) {
        for (Lotto lotto : lottos.getLottos()) {
            int rank = lotto.matchLottoToWinNum(numbers, bonus);
            statistics.addWinCount(rank);
        }
    }

    public double calculateProfit(int purchaseMoney) {
        return (double) statistics.totalReward() / purchaseMoney;
    }

    public List<String> gameResult() {
        List<String> result = new ArrayList<>();
        int index = 0;
        for (Rank rank : Rank.values()) {
            result.add(rank.getResultLine(statistics.getWinCount(index), index));
            index++;
        }
        return result;
    }
}
