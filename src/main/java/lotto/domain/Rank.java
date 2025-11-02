package lotto.domain;

public enum Rank {
    MATCH_THREE(3, 5_000),
    MATCH_FOUR(4, 50_000),
    MATCH_FIVE(5, 1_500_000),
    MATCH_FIVE_BONUS(5, 30_000_000),
    MATCH_SIX(6, 2_000_000_000);

    private final int matches;
    private final int reward;

    Rank(int matches, int reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public long getReward(int counts) {
        return (long) reward * counts;
    }

    public String getResultLine(int count) {
        StringBuilder result = new StringBuilder();
        result.append(matches + "개 일치, ");
        if (this.equals(MATCH_FIVE_BONUS) && count == 3) {
            result.append("보너스 볼 일치 ");
        }
        result.append("(" + reward + "원) - " + count + "개\n");
        return result.toString();
    }

}
