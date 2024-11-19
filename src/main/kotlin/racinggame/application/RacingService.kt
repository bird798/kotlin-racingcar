package racinggame.application

import racinggame.core.Car
import racinggame.core.Race
import racinggame.core.Round
import racinggame.core.condition.MoveCondition

object RacingService {
    private const val ERROR_CAR_COUNT = "차량 개수가 잘못되었습니다."
    private const val ERROR_ROUND_COUNT = "라운드 횟수가 잘못되었습니다."

    fun start(
        names: List<String>,
        moveCondition: MoveCondition,
        roundCount: Int,
    ) {
        require(!names.isEmpty()) { ERROR_CAR_COUNT }
        require(roundCount > 0) { ERROR_ROUND_COUNT }

        val cars = MutableList<Car>(names.size) { i -> Car(names[i], 0) }

        repeat(roundCount) {
            Race.goRound(cars, moveCondition)
        }
    }

    fun roundResult(): List<Round> {
        return Race.roundResult()
    }

    fun racingWinner(): List<Car> {
        return Race.racingWinner()
    }
}
