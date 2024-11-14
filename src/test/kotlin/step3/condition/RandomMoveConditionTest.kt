package step3.condition

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class RandomMoveConditionTest {
    @Test
    fun `생성자를 테스트한다`() {
        assertThatIllegalArgumentException().isThrownBy { RandomMoveCondition((0..0), 1) }
        assertThatIllegalArgumentException().isThrownBy { RandomMoveCondition((0..5), -1) }
        assertThatIllegalArgumentException().isThrownBy { RandomMoveCondition((0..5), 10) }
    }
}
