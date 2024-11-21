package racinggame.core

import racinggame.core.condition.MoveCondition

class Car(
    name: String,
    position: Int = 0,
) {
    var name: String = name.trim()
        private set
    var position: Int = position
        private set

    init {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        return this.name == other.name && this.position == other.position
    }

    // hashCode 구현
    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    fun copy(
        name: String = this.name,
        position: Int = this.position,
    ): Car {
        return Car(name, position)
    }
}
