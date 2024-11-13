package step2

class Calculator() {
    enum class OPERATOR(val operator: String, val func: (Double, Double) -> Double) {
        PLUS("+", { a, b -> a + b }),
        MINUS("-", { a, b -> a - b }),
        MULTIPLY("*", { a, b -> a * b }),
        DIVIDE("/", { a, b -> a / b }),
        ;

        companion object {
            val map = values().associateBy(OPERATOR::operator)

            fun get(operation: String): OPERATOR? {
                return map[operation]
            }
        }
    }

    companion object {
        const val SEPARATOR = " "
    }

    fun calculate(formula: String): Double {
        val factors = split(formula)
        if (factors.isEmpty() || (factors.size % 2 != 1)) {
            throw IllegalArgumentException("잘못된 수식입니다.")
        }

        var result = factors[0].toDoubleOrNull() ?: throw IllegalArgumentException("잘못된 수식입니다.")
        for (i in 1 until factors.size step 2) {
            val operator = OPERATOR.get(factors[i]) ?: throw IllegalArgumentException("정의되지 않은 연산자입니다.")
            val number = factors[i + 1].toDoubleOrNull() ?: throw IllegalArgumentException("잘못된 수식입니다.")
            result = operator.func(result, number)
        }

        return result
    }

    private fun split(formula: String): List<String> {
        val factors = formula.trim().split(SEPARATOR)
        if (factors.isEmpty()) {
            throw IllegalArgumentException()
        }
        return factors
    }
}
