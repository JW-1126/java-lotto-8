package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.number.NumberStrategy;
import lotto.repository.Lottos;

public class LottoService {
    private final NumberStrategy strategy;
    private final Lottos lottos;

    public LottoService(NumberStrategy strategy, Lottos lottos) {
        this.strategy = strategy;
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

}
