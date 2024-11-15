package racinggame.core

import racinggame.core.condition.MoveCondition

class Race(carCount: Int, moveCondition: MoveCondition) {
    init {
        require(carCount > 0) { ERROR_CAR_COUNT }
    }

    companion object {
        const val ERROR_CAR_COUNT = "차량 개수가 잘못되었습니다."
    }

    val cars: MutableList<Car> = MutableList(carCount) { index -> Car("#${index + 1}", moveCondition::canMove) }

    fun move() {
        cars.forEach { car -> car.tryMove() }
    }
}
