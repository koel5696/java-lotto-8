package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoPriceTest {
    @Test
    void 구입_금액이_정상적으로_생성된다() {
        assertThatCode(() -> new LottoPrice(10000))
                .doesNotThrowAnyException();
    }

    @Test
    void 구입_금액이_천의_배수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPrice(10004)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
