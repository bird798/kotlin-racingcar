package step3

import step3.condition.RandomMoveCondition
import step3.ui.InputView
import step3.ui.ResultView

class RacingGame {
    companion object {
        private const val CAR_COUNT_GUIDE_TEXT = "자동차 대수는 몇 대인가요?"
        private const val MOVEMENT_COUNT_GUIDE_TEXT = "시도할 횟수는 몇 회인가요?"
    }

    fun start() {
        val carCount = InputView(CAR_COUNT_GUIDE_TEXT).inputNumber()
        val movementCount = InputView(MOVEMENT_COUNT_GUIDE_TEXT).inputNumber()

        val race = Race(carCount, RandomMoveCondition((0..9), 4))
        val resultView = ResultView(race)

        println("레이싱 시작\n")
        for (i in 0 until movementCount) {
            race.move()
            resultView.draw()
        }
        println("레이싱 종료")
    }
}
