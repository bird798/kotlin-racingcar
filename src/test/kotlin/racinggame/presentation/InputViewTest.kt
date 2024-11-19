package racinggame.presentation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", "", "-1", "0"])
    fun `입력받은 숫자의 유효성체크 기능을 테스트한다`(value: String?) {
        assertThat(InputView.isValidNumber(value)).isEqualTo(false)
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
        val resultList = listOf(value2, value3)
        assertThat(InputView.split(value)).isEqualTo(resultList)
    }
}
