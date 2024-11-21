package racinggame.application

import racinggame.core.condition.RandomMoveCondition
import racinggame.presentation.InputView
import racinggame.presentation.ResultView

class RacingController() {
    fun start() {
        val names = InputView.inputStrings()
        val movementCount = InputView.inputNumber()

        val raceResult = RacingService.start(names, RandomMoveCondition(), movementCount)
        ResultView().drawRacingResult(raceResult)
    }
}
