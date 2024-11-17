package racinggame.presentation

import racinggame.core.Round

class ResultView() {
    companion object {
        private const val DRIVING_LINE = "-"
    }

    private fun drawRoundResult(round: Round) {
        round.cars.forEach { car -> println("${car.name} ${DRIVING_LINE.repeat(car.position)}") }
        println()
    }

    fun drawRacingResult(rounds: List<Round>) {
        println("실행 결과")
        rounds.forEach { round ->
            drawRoundResult(round)
            println()
        }
    }
}
