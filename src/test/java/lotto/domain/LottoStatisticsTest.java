package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @Test
    @DisplayName("인덱스를 전달받아 값을 1 증가시킨다")
    void addWinCount_GetIndex_UpperValue() {
        //given
        LottoStatistics lottoStatistics = new LottoStatistics();

        //when
        lottoStatistics.addWinCount(1);
        lottoStatistics.addWinCount(2);
        lottoStatistics.addWinCount(2);

        //then
        assertThat(lottoStatistics.getWinCount(1)).isEqualTo(1);
        assertThat(lottoStatistics.getWinCount(2)).isEqualTo(2);
    }
}