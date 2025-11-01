package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BonusNumberInputValidTest {

    @Test
    void 보너스_번호가_정상적으로_입력됐다() {
        String inputBonus = "30";
        assertThatCode(() -> BonusInputValid.validate(inputBonus))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스_번호_입력_오버플로우_예외_테스트() {
        String inputBonus = "100042432454342343424235346546";
        assertThatThrownBy(() -> BonusInputValid.validate(inputBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 비정상적으로 큰 입력입니다.");
    }

    @Test
    void 보너스_번호_입력_문자_예외_테스트() {
        String inputBonus = "잘못 입력";
        assertThatThrownBy(() -> BonusInputValid.validate(inputBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 보너스 번호는 정수로 입력해주세요.");
    }

    @Test
    void 보너스_번호_입력_공백_예외_테스트() {
        String inputBonus = " ";
        assertThatThrownBy(() -> BonusInputValid.validate(inputBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 빈(공백) 값이 들어왔습니다.");
    }

    @Test
    void 보너스_번호_입력_0시작_예외_테스트() {
        String inputBonus = "0005";
        assertThatThrownBy(() -> BonusInputValid.validate(inputBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 숫자는 0으로 시작할 수 없습니다.");
    }
}
