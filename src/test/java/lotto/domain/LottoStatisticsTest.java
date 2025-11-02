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

    @Test
    @DisplayName("각 순위의 당첨 갯수와 상금을 계산하여 합을 반환한다.")
    void totalReward_ReturnSum() {
        //given
        LottoStatistics lottoStatistics = new LottoStatistics();

        //when
        lottoStatistics.addWinCount(1); //       50,000
        lottoStatistics.addWinCount(2); //    1,500,000
        lottoStatistics.addWinCount(2); //    1,500,000
        lottoStatistics.addWinCount(3); //   30,000,000
        lottoStatistics.addWinCount(4); //2,000,000,000

        assertThat(lottoStatistics.totalReward()).isEqualTo(2033050000);
    }
}