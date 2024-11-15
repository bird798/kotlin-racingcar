package racinggame

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racinggame.application.RacingService
import racinggame.core.condition.RandomMoveCondition

class RacingServiceTest {
    @Test
    fun `생성자 테스트`() {
        val moveCondition = RandomMoveCondition((0..9), 4)
        assertThatIllegalArgumentException().isThrownBy { RacingService(0, moveCondition) }
        assertThatIllegalArgumentException().isThrownBy { RacingService(-1, moveCondition) }
    }
}
