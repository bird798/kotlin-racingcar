package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @Test
    fun testCalc() {
        val calculator = Calculator()

        assertThat(calculator.calculate("1.0")).isEqualTo(1.0)
        assertThat(calculator.calculate("1.0 + 1.5")).isEqualTo(2.5)
        assertThat(calculator.calculate("1 - 1.5")).isEqualTo(-0.5)
        assertThat(calculator.calculate("1 * 2")).isEqualTo(2.0)
        assertThat(calculator.calculate("1 / 2")).isEqualTo(0.5)
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["=", "1 a 1", "1 -", "- 1", "1+1", "1+ 1"])
    fun testCalulateException(input: String?) {
        val calculator = Calculator()
        assertThatIllegalArgumentException().isThrownBy { input?.let { calculator.calculate(it) } }
    }
}
