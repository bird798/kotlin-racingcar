package racinggame.application

import racinggame.core.Car
import racinggame.core.Race
import racinggame.core.RaceResult
import racinggame.core.condition.MoveCondition

object RacingService {
    private const val ERROR_CAR_COUNT = "차량 개수가 잘못되었습니다."
    private const val ERROR_ROUND_COUNT = "라운드 횟수가 잘못되었습니다."

    fun start(
        names: List<String>,
        moveCondition: MoveCondition,
        roundCount: Int,
    ): RaceResult {
        require(names.isNotEmpty()) { ERROR_CAR_COUNT }
        require(roundCount > 0) { ERROR_ROUND_COUNT }

        val cars = ArrayDeque(names.map(::Car))

        val race = Race()
        repeat(roundCount) {
            race.goRound(cars, moveCondition)
        }

        return RaceResult(race.roundResult(), race.racingWinner())
    }
}
