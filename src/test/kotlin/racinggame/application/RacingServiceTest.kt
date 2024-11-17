package racinggame.application

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racinggame.core.Car
import racinggame.core.Round
import racinggame.core.condition.RandomMoveCondition

class RacingServiceTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `잘못된 파라미터가 주어질때를 테스트한다`(value: Int) {
        val racingService = RacingService()
        val moveCondition = RandomMoveCondition((0..9), 4)

        assertThatIllegalArgumentException().isThrownBy { racingService.start(value, moveCondition) }
    }

    @Test
    fun `레이스 시작 전에 함수 호출을 테스트한다`() {
        val racingService = RacingService()

        assertAll(
            "변수 초기화전에 호출 시 오류가 발생함을 테스트한다.",
            { assertThatIllegalArgumentException().isThrownBy { racingService.goRound() } },
            { assertThatIllegalArgumentException().isThrownBy { racingService.roundStatus() } },
        )
    }

    @Test
    fun `레이싱 상태를 얻는 함수를 테스트한다`() {
        val racingService = RacingService()
        val moveCondition = RandomMoveCondition((0..0), 0)
        racingService.start(3, moveCondition)

        assertThat(racingService.roundStatus()).isEqualTo(Round(MutableList(3) { index -> Car("#${index + 1}", 0) }))
        racingService.goRound()
        assertThat(racingService.roundStatus()).isEqualTo(Round(MutableList(3) { index -> Car("#${index + 1}", 1) }))
    }
}
