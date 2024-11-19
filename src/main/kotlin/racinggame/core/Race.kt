package racinggame.core

import racinggame.core.condition.MoveCondition

class Race {
    private var rounds: MutableList<Round> = mutableListOf()

    fun goRound(
        cars: List<Car>,
        moveCondition: MoveCondition,
    ) {
        cars.forEach { car -> car.move(moveCondition) }
        rounds.add(Round(cars.map { it.copy() }))
    }

    fun roundResult(): List<Round> {
        return rounds
    }

    fun racingWinner(): List<Car> {
        require(rounds.isNotEmpty())
        val lastRound = rounds.last()
        val cars = lastRound.cars.sortedByDescending { it.position }
        return cars.filter { it.position == cars.first().position }
    }
}
