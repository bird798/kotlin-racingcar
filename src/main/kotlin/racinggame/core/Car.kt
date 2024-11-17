package racinggame.core

import racinggame.core.condition.MoveCondition

data class Car(
    val name: String,
    var position: Int,
) {
    init {
        require(name.isNotBlank())
    }

    fun move(condition: MoveCondition) {
        if (condition.canMove()) position += 1
    }
}
