package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.Lottos;
import lotto.service.LottoService;

public class AppConfig {

    public Lottos lottos() {
        return new Lottos();
    }

    public LottoService lottoService() {
        return new LottoService(lottos());
    }

    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

}
