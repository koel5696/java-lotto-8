package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoPriceInputValidTest {
    @Test
    void 구입_금액이_정상적으로_생성된다() {
        String inputPrice = "10000";
        assertThatCode(() -> PriceInputValid.validate(inputPrice))
                .doesNotThrowAnyException();
    }

    @Test
    void 구입_금액_입력_오버플로우_예외_테스트() {
        String inputPrice = "100042432454342343424235346546";
        assertThatThrownBy(() -> PriceInputValid.validate(inputPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 비정상적으로 큰 입력입니다.");
    }

    @Test
    void 구입_금액_입력_문자_예외_테스트() {
        String inputPrice = "잘못 입력";
        assertThatThrownBy(() -> PriceInputValid.validate(inputPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 보너스 번호는 정수로 입력해주세요.");
    }

    @Test
    void 구입_금액_입력_공백_예외_테스트() {
        String inputPrice = " ";
        assertThatThrownBy(() -> PriceInputValid.validate(inputPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 빈(공백) 값이 들어왔습니다.");
    }

    @Test
    void 구입_금액_입력_0시작_예외_테스트() {
        String inputAmount = "0005";
        assertThatThrownBy(() -> AmountInputValid.validate(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 숫자는 0으로 시작할 수 없습니다.");
    }
}
