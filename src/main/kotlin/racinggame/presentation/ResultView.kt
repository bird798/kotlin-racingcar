package racinggame.presentation

import racinggame.core.Round

class ResultView() {
    companion object {
        private const val DRIVING_LINE = "-"
    }

    fun start() {
        println("레이싱 시작")
    }

    fun drawRacingStatus(round: Round) {
        round.cars.forEach { car -> println("${car.name} ${DRIVING_LINE.repeat(car.position)}") }
        println()
    }
}
