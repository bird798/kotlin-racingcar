package racinggame.presentation

import racinggame.core.Car
import racinggame.core.RaceResult
import racinggame.core.Round

class ResultView() {
    fun drawRacingResult(raceResult: RaceResult) {
        println("실행 결과")
        raceResult.roundList.forEach { round ->
            drawRoundResult(round)
        }
        drawWinner(raceResult.winners)
    }

    private fun drawWinner(cars: List<Car>) {
        val strBuilder = StringBuilder()

        strBuilder.append(cars.joinToString(",") { it.name })
        strBuilder.append("가 최종 우승했습니다.")
        println(strBuilder.toString())
    }

    private fun drawRoundResult(round: Round) {
        val strBuilder = StringBuilder()

        round.cars.forEach { car ->
            strBuilder.append("${car.name} ${DRIVING_LINE.repeat(car.position)}\n")
        }
        println(strBuilder.toString())
    }

    companion object {
        private const val DRIVING_LINE = "-"
    }
}
