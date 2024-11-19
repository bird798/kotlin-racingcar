package racinggame.core

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racinggame.core.condition.RandomMoveCondition

class RaceTest {
    @Test
    fun `레이싱 승자를 얻는 기능의 오류를 테스트한다`() {
        assertThatIllegalArgumentException().isThrownBy { Race().racingWinner() }
    }

    @Test
    fun `레이싱 승자를 얻는 기능을 테스트한다`() {
        val race = Race()
        race.goRound(mutableListOf(Car("1", 0), Car("2", 0)), RandomMoveCondition((0..0), 0))
        assertThat(race.racingWinner()).isEqualTo(mutableListOf(Car("1", 1), Car("2", 1)))
    }
}
