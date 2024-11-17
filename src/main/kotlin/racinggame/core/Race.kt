package racinggame.core

import racinggame.core.condition.MoveCondition

object Race {
    fun goRound(
        cars: MutableList<Car>,
        moveCondition: MoveCondition,
    ): Round {
        cars.forEach { car -> car.move(moveCondition) }
        return Round(cars.map { it.copy() })
    }
}
