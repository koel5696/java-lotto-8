package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinningNumberInputValidTest {
    @Test
    void 당첨_번호가_정상적으로_생성된다() {
        String inputLotto = "1,2,3,4,5,6";
        assertThatCode(() -> LottoInputValid.validate(inputLotto))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨_번호_입력_오버플로우_예외_테스트() {
        String inputLotto = "1,2,3,4,5,64535343453534535336464534634654453";
        assertThatThrownBy(() -> LottoInputValid.validate(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 비정상적으로 큰 입력입니다.");
    }

    @Test
    void 당첨_번호_입력_문자_예외_테스트() {
        String inputLotto = "잘못 입력";
        assertThatThrownBy(() -> LottoInputValid.validate(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 보너스 번호는 정수로 입력해주세요.");
    }

    @Test
    void 당첨_번호_입력_공백_예외_테스트() {
        String inputLotto = " ";
        assertThatThrownBy(() -> LottoInputValid.validate(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 빈(공백) 값이 들어왔습니다.");
    }

    @Test
    void 당첨_번호_입력_0시작_예외_테스트() {
        String inputLotto = "1,002,3,4,5,6";
        assertThatThrownBy(() -> LottoInputValid.validate(inputLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 숫자는 0으로 시작할 수 없습니다.");
    }
}
