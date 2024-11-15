package racinggame

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racinggame.core.Race
import racinggame.core.condition.RandomMoveCondition

class RaceTest {
    @Test
    fun `생성자 테스트`() {
        val moveCondition = RandomMoveCondition((0..9), 4)
        assertThatIllegalArgumentException().isThrownBy { Race(0, moveCondition) }
        assertThatIllegalArgumentException().isThrownBy { Race(-1, moveCondition) }
    }
}
