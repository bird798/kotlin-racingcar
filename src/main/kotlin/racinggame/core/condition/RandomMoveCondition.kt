package racinggame.core.condition

class RandomMoveCondition(private val range: IntRange = intRange, private val threshold: Int = THRESHOLD) : MoveCondition {
    init {
        require((range.first <= threshold) && (threshold <= range.last)) { ERROR_MESSAGE_THRESHOLD_ERROR }
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

    companion object {
        private const val ERROR_MESSAGE_THRESHOLD_ERROR = "범위가 잘못되었습니다."
        private const val THRESHOLD = 4
        private val intRange = (0..9)
    }
}
