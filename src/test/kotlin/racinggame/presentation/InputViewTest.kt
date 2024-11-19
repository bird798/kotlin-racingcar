package racinggame.presentation

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `생성자 테스트한다`(value: String?) {
        assertThatIllegalArgumentException().isThrownBy { InputView(value!!) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "", "-1", "0"])
    fun `입력받은 숫자의 유효성체크 기능을 테스트한다`(value: String?) {
        val input = InputView("Test")
        assertThat(input.isValidNumber(value)).isEqualTo(false)
    }

    @ParameterizedTest
    @ValueSource(strings = ["   ", "abcdefg", "", "abcdefg, a"])
    fun `입력받은 문자열을 유효성 기능을 테스트한다`(value: String) {
        val input = InputView("Test")
        assertThatIllegalArgumentException().isThrownBy { input.split(value, ",", 5) }
    }

    @ParameterizedTest
    @CsvSource(
        "'a,b', 'a', 'b'",
    )
    fun `입력받은 문자열을 분해하는 기능을 테스트한다`(
        value: String,
        value2: String,
        value3: String,
    ) {
        val input = InputView("Test")
        val resultList = listOf(value2, value3)
        assertThat(input.split(value, ",", 5)).isEqualTo(resultList)
    }
}
