package racinggame.core.condition

class RandomMoveCondition(val range: IntRange, val threshold: Int) : MoveCondition {
    init {
        require((range.first <= threshold) && (threshold <= range.last)) { ERROR_MESSAGE_THRESHOLD_ERROR }
    }

    companion object {
        const val ERROR_MESSAGE_THRESHOLD_ERROR = "범위가 잘못되었습니다."
    }

    private fun generate(): Int {
        return range.random()
    }

    fun canMove(number: Int): Boolean {
        return number >= threshold
    }

    override fun canMove(): Boolean {
        return canMove(generate())
    }
}
