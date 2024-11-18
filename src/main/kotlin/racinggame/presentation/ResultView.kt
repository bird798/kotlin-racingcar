package racinggame.presentation

import racinggame.core.Round

class ResultView() {
    companion object {
        private const val DRIVING_LINE = "-"
    }

    private fun drawRoundResult(round: Round) {
        val strBuilder = StringBuilder()

        round.cars.forEach { car ->
            strBuilder.append("${car.name} ${DRIVING_LINE.repeat(car.position)}\n")
        }
        println(strBuilder.toString())
    }

    fun drawRacingResult(rounds: List<Round>) {
        println("실행 결과")
        rounds.forEach { round ->
            drawRoundResult(round)
        }
    }
}
