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
        "0, 1",
        "-1, 1",
        "1, -0",
        "1, 0",
    )
    fun `잘못된 파라미터가 주어질때를 테스트한다`(
        carCount: Int,
        roundCount: Int,
    ) {
        val moveCondition = RandomMoveCondition((0..9), 4)

        assertThatIllegalArgumentException().isThrownBy { RacingService.start(carCount, moveCondition, roundCount) }
    }

    @Test
    fun `레이싱 상태를 얻는 함수를 테스트한다`() {
        val moveCondition = RandomMoveCondition((0..0), 0)
        RacingService.start(3, moveCondition, 4)

        var roundIndex = 0
        RacingService.racingResult().forEach { round ->
            assertThat(round).isEqualTo(Round(MutableList(3) { index -> Car("#${index + 1}", roundIndex + 1) }))
            roundIndex++
        }
    }
}
