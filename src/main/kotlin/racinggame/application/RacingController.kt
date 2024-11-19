package racinggame.application

import racinggame.core.condition.RandomMoveCondition
import racinggame.presentation.InputView
import racinggame.presentation.ResultView

class RacingController() {
    companion object {
        private const val THRESHOLD = 4
        private val intRange = (0..9)
    }

    fun start() {
        val names = InputView.inputStrings()
        val movementCount = InputView.inputNumber()

        val raceResult = RacingService.start(names, RandomMoveCondition(intRange, THRESHOLD), movementCount)
        ResultView().drawRacingResult(raceResult)
    }
}
