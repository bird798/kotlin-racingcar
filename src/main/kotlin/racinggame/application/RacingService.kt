package racinggame.application

import racinggame.core.Car
import racinggame.core.Round
import racinggame.core.condition.MoveCondition

class RacingService() {
    companion object {
        const val ERROR_CAR_COUNT = "차량 개수가 잘못되었습니다."
    }

    lateinit var cars: MutableList<Car>
    private lateinit var moveCondition: MoveCondition

    fun start(
        carCount: Int,
        moveCondition: MoveCondition,
    ) {
        require(carCount > 0) { ERROR_CAR_COUNT }

        this.cars = MutableList(carCount) { index -> Car("#${index + 1}", 0) }
        this.moveCondition = moveCondition
    }

    fun goRound() {
        cars.forEach { car -> if (moveCondition.canMove()) car.move() }
    }

    fun roundStatus(): Round {
        return Round(cars)
    }
}
