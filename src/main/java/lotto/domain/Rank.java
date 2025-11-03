package lotto.domain;

import java.util.Optional;

public enum Rank {
    THREE(3, 5_000, "3개 일치 (5,000원) - "),
    FOUR(4, 50_000, "4개 일치 (50,000원) - "),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FIVE_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final int prize;
    private final String CORRESPOND;

    Rank(int matchCount, int prize, String correspond) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.CORRESPOND = correspond;
    }

    public int getPrize() {
        return prize;
    }

    public String getCorrespond() {
        return CORRESPOND;
    }

    public static Optional<Rank> determineWinAmount(int collectNumber, boolean fiveAndBonus) {
        if (fiveAndBonus) {
            return Optional.of(FIVE_BONUS);
        }
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == collectNumber) {
                return Optional.of(rank);
            }
        }
        return Optional.empty();
    }
}
