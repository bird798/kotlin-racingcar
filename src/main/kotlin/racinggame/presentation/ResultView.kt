package racinggame.presentation

import racinggame.core.Race

class ResultView(val race: Race) {
    companion object {
        private const val DRIVING_LINE = "-"
    }

    fun draw() {
        race.cars.forEach { car -> println("${car.name} ${DRIVING_LINE.repeat(car.moveCount)}") }
        println()
    }
}
