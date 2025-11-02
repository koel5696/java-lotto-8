package lotto.domain;

import java.util.Optional;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
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
