package lotto.domain;

public class LottoPrice {
    private static final String THOUSAND_MULTI_NUMBER_ERROR_MESSAGE = "[ERROR] 금액은 천 단위의 양수여야 합니다.";
    private static final int LOTTO_ONE_UINT_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private final int lottoPrice;

    public LottoPrice(int lottoPrice) {
        thousandMultiValid(lottoPrice);
        this.lottoPrice = lottoPrice;
    }

    private void thousandMultiValid(int amount) {
        if (amount % LOTTO_ONE_UINT_PRICE != 0) {
            throw new IllegalArgumentException(THOUSAND_MULTI_NUMBER_ERROR_MESSAGE);
        }
    }

    public int lottoCount() {
        return lottoPrice / LOTTO_ONE_UINT_PRICE;
    }

    public double profit(double total) {
        double profit = (total / lottoPrice) * PERCENTAGE;
        return Math.round(profit * 10) / 10.0; // 반올림
    }
}
