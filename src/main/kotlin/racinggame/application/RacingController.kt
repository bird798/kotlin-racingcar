package racinggame.application

import racinggame.core.condition.RandomMoveCondition
import racinggame.presentation.InputView
import racinggame.presentation.ResultView

class RacingController(private val racingService: RacingService) {
    companion object {
        private const val CAR_COUNT_GUIDE_TEXT = "자동차 대수는 몇 대인가요?"
        private const val MOVEMENT_COUNT_GUIDE_TEXT = "시도할 횟수는 몇 회인가요?"
        private const val THRESHOLD = 4

        private val intRange = (0..9)
    }

    fun start() {
        // 입력을 받는다.
        val carCount = InputView(CAR_COUNT_GUIDE_TEXT).inputNumber()
        val movementCount = InputView(MOVEMENT_COUNT_GUIDE_TEXT).inputNumber()

        racingService.start(carCount, RandomMoveCondition(intRange, THRESHOLD))
        ResultView().start()

        for (i in 0 until movementCount) {
            racingService.goRound()
            ResultView().drawRacingStatus(racingService.roundStatus())
        }
    }
}
