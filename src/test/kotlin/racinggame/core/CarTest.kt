package racinggame.core

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racinggame.core.condition.RandomMoveCondition

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `생성자를 테스트한다`() {
        assertThatIllegalArgumentException().isThrownBy { Car("", 0) }
    }

    @Test
    fun `이동을 확인한다`() {
        val car = Car("test", 1)
        car.move(RandomMoveCondition(0..0, 0))
        assertThat(car.position).isEqualTo(2)
    }
}
