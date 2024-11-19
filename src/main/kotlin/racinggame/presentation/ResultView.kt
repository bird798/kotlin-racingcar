package racinggame.presentation

import racinggame.core.Car
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

    fun drawWinner(cars: List<Car>) {
        val strBuilder = StringBuilder()

        cars.forEachIndexed { index, car ->
            appendName(strBuilder, car.name, index)
        }
        strBuilder.append("가 최종 우승했습니다.")
        println(strBuilder.toString())
    }

    private fun appendName(
        strBuilder: StringBuilder,
        value: String,
        index: Int,
    ) {
        if (index > 0) {
            strBuilder.append(", ")
        }

        strBuilder.append(value)
    }

    fun drawRacingResult(
        rounds: List<Round>,
        winner: List<Car>,
    ) {
        println("실행 결과")
        rounds.forEach { round ->
            drawRoundResult(round)
        }
        drawWinner(winner)
    }
}
