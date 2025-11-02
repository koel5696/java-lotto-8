package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoInputValidatorTest {
    @Test
    void 당첨_번호가_정상적으로_생성된다() {
        assertThatCode(() -> LottoInputValidator.lottoNumberInputValidator("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨_번호_입력_형식_예외_테스트() {
        assertThatThrownBy(() -> LottoInputValidator.lottoNumberInputValidator("잘못 입력"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표(,)로 구분하고, 빈 값 없이 자연수로 입력해야 합니다.");
    }

}
