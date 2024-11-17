package racinggame.application

import racinggame.core.Car
import racinggame.core.Race
import racinggame.core.Round
import racinggame.core.condition.MoveCondition

object RacingService {
    private const val ERROR_CAR_COUNT = "차량 개수가 잘못되었습니다."
    private const val ERROR_ROUND_COUNT = "라운드 횟수가 잘못되었습니다."

    var cars: MutableList<Car> = mutableListOf()
    var rounds: MutableList<Round> = mutableListOf()

    fun start(
        carCount: Int,
        moveCondition: MoveCondition,
        roundCount: Int,
    ) {
        require(carCount > 0) { ERROR_CAR_COUNT }
        require(roundCount > 0) { ERROR_ROUND_COUNT }

        for (i in 0 until carCount) cars.add(Car("#${i + 1}", 0))

        repeat(roundCount) {
            rounds.add(Race.goRound(cars, moveCondition))
        }
    }

    fun racingResult(): List<Round> {
        return rounds
    }
}
