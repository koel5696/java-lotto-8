package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberInputValidatorTest {

    @Test
    void 숫자가_정상적으로_입력됐다() {
        assertThatCode(() -> NumberInputValidator.numberInputValidator("30"))
                .doesNotThrowAnyException();
    }

    @Test
    void 오버플로우_예외_테스트() {
        assertThatThrownBy(() -> NumberInputValidator.numberInputValidator("100042432454342343424235346546"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력이 비정상적으로 큽니다.");
    }

    @Test
    void 문자_예외_테스트() {
        assertThatThrownBy(() -> NumberInputValidator.numberInputValidator("잘못 입력"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 0으로 시작하지 않는 자연수만 입력할 수 있습니다.");
    }

    @Test
    void 공백_예외_테스트() {
        assertThatThrownBy(() -> NumberInputValidator.numberInputValidator(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈(공백) 값이 들어왔습니다.");
    }
}
