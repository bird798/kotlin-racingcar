package racinggame.presentation

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `생성자 테스트한다`(value: String?) {
        assertThatIllegalArgumentException().isThrownBy { InputView(value!!) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "", "-1", "0"])
    fun `입력받은 문자열의 유효성체크 기능을 테스트한다`(value: String?) {
        val input = InputView("Test")
        assertThat(input.isValid(value)).isEqualTo(false)
    }
}
