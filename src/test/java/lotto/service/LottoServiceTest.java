package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.repository.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {

    @ParameterizedTest
    @DisplayName("입력 수량만큼의 로또가 저장된다")
    @CsvSource({"8", "5"})
    void createLotto_InputQuantity_SameCountLottoCreated(int quantity) {
        //given
        Lottos lottos = new Lottos();
        LottoService lottoService = new LottoService(lottos);

        //when
        lottoService.createLotto(quantity);

        //then
        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }

}