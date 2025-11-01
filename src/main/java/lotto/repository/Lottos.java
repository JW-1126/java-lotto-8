package lotto.repository;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.Lotto;

public class Lottos {

    private final Set<Lotto> lottos = new HashSet<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public HashSet<Lotto> getLottos() {
        return new HashSet<>(lottos);
    }

}
