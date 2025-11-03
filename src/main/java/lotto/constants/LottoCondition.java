package lotto.constants;

public enum LottoCondition {
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBER_COUNT(6);

    private final int value;

    LottoCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
