package racinggame.application

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racinggame.core.Car
import racinggame.core.Round
import racinggame.core.condition.RandomMoveCondition

class RacingServiceTest {
    @ParameterizedTest
    @CsvSource(
        "'', 1",
        "'abcdef,abc', 1",
        "'a,b', -1",
        "'a,b', 0",
    )
    fun `잘못된 파라미터가 주어질때를 테스트한다`(
        str: String,
        roundCount: Int,
    ) {
        val moveCondition = RandomMoveCondition((0..9), 4)
        val names = str.split(",")

        assertThatIllegalArgumentException().isThrownBy { RacingService.start(names, moveCondition, roundCount) }
    }

    @Test
    fun `라운드 결과를 얻는 함수를 테스트한다`() {
        val moveCondition = RandomMoveCondition((0..0), 0)
        val result = RacingService.start(listOf("1", "2", "3"), moveCondition, 4)

        var roundIndex = 0
        result.roundList.forEach { round ->
            assertThat(round).isEqualTo(Round(MutableList(3) { index -> Car("${index + 1}", roundIndex + 1) }))
            roundIndex++
        }
    }

    @Test
    fun `레이싱 승자를 얻는 함수를 테스트한다`() {
        val moveCondition = RandomMoveCondition((0..0), 0)
        val result = RacingService.start(listOf("1", "2", "3"), moveCondition, 4)

        assertThat(result.winners).isEqualTo(listOf(Car("1", 4), Car("2", 4), Car("3", 4)))
    }
}
