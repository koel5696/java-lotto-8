package lotto.domain;

public class LottoPrice {
    private final int value;

    public LottoPrice(int lottoPrice) {
        thousandMultiValid(lottoPrice);
        this.value = lottoPrice;
    }


    private void thousandMultiValid(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 천 단위의 양수여야 합니다.");
        }
    }

    public int lottoCount() {
        return value / 1000;
    }
}
