package racinggame.core.condition

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RandomMoveConditionTest {
    @ParameterizedTest
    @CsvSource(
        "0, 0, 1",
        "0, -5, 1",
        "0, 5, -1",
        "2, 5, 1",
        "0, 5, 10",
    )
    fun `생성자에 잘못된 파라미터가 전달되었을 때를 테스트한다`(
        rangeMin: Int,
        rangeMax: Int,
        threshold: Int,
    ) {
        assertThatIllegalArgumentException().isThrownBy { RandomMoveCondition((rangeMin..rangeMax), threshold) }
    }

    @ParameterizedTest
    @CsvSource(
        "1, false",
        "4, true",
        "9, true",
    )
    fun `Condition이 정상동작함을 확인한다`(
        number: Int,
        result: Boolean,
    ) {
        val condition = RandomMoveCondition((0..9), 4)
        assertThat(condition.canMove(number)).isEqualTo(result)
    }
}
