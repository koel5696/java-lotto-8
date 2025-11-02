package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        rangeValidate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void rangeValidate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }
    }
}
