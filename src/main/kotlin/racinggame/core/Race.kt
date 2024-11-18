package racinggame.core

import racinggame.core.condition.MoveCondition

object Race {
    private var rounds: MutableList<Round> = mutableListOf()

    fun goRound(
        cars: MutableList<Car>,
        moveCondition: MoveCondition,
    ) {
        cars.forEach { car -> car.move(moveCondition) }

        rounds.add(Round(cars.map { it.copy() }))
    }

    fun racingResult(): List<Round> {
        return rounds
    }
}
