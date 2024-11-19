package racinggame.application

import racinggame.core.condition.RandomMoveCondition
import racinggame.presentation.InputView
import racinggame.presentation.ResultView

class RacingController() {
    companion object {
        private const val CAR_COUNT_GUIDE_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val MOVEMENT_COUNT_GUIDE_TEXT = "시도할 횟수는 몇 회인가요?"

        private const val DELIMITER = ","
        private const val MAX_NAME_LENGTH = 5

        private const val THRESHOLD = 4
        private val intRange = (0..9)
    }

    fun start() {
        val names = InputView(CAR_COUNT_GUIDE_TEXT).inputStrings(DELIMITER, MAX_NAME_LENGTH)
        val movementCount = InputView(MOVEMENT_COUNT_GUIDE_TEXT).inputNumber()

        RacingService.start(names, RandomMoveCondition(intRange, THRESHOLD), movementCount)
        ResultView().drawRacingResult(RacingService.roundResult(), RacingService.racingWinner())
    }
}
