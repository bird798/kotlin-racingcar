package racinggame.core

import racinggame.core.condition.MoveCondition

data class Car(
    var name: String,
    var position: Int,
) {
    init {
        this.name = name.trim()
        require(name.isNotBlank())
        require(name.length <= MAX_NAME_LENGTH)
    }

    fun move(condition: MoveCondition) {
        if (condition.canMove()) {
            position += 1
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
