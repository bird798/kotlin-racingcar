package step3.condition

class RandomMoveCondition(val range: IntRange, val threshold: Int) : MoveCondition {
    init {
        if ((threshold < range.first) || (range.last < threshold)) {
            throw IllegalArgumentException("범위가 잘못되었습니다.")
        }
    }

    override fun canMove(): Boolean {
        val randomInt = range.random()
        return randomInt >= threshold
    }
}
