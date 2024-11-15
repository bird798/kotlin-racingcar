package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "'1.0', 1.0",
        "'1.0 + 1.5', 2.5",
        "'1 * 2', 2.0",
        "'1 / 2', 0.5",
        "'2 + 3 * 4 / 2', 10.0",
    )
    @DisplayName("계산 술식을 입력하여 그 값이 정상적인지 테스트합니다.")
    fun testCalculate(
        input: String?,
        output: Double?,
    ) {
        val calculator = Calculator()

        assertThat(input?.let { calculator.calculate(it) }).isEqualTo(output)
    }

    @DisplayName("잘못된 술식을 입력하여 IllegalArgumentException이 정상적으로 발생함을 테스트합니다")
    @ParameterizedTest
    @ValueSource(strings = ["=", "1 a 1", "1 -", "- 1", "1+1", "1+ 1", "1 1"])
    fun testCalulateException(input: String?) {
        val calculator = Calculator()
        assertThatIllegalArgumentException().isThrownBy { input?.let { calculator.calculate(it) } }
    }
}
