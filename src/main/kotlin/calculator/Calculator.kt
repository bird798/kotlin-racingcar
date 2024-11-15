package calculator

class Calculator() {
    enum class OPERATOR(val operator: String, val apply: (Double, Double) -> Double) {
        PLUS("+", { a, b -> a + b }),
        MINUS("-", { a, b -> a - b }),
        MULTIPLY("*", { a, b -> a * b }),
        DIVIDE("/", { a, b -> if (b != 0.0) a / b else throw IllegalArgumentException(ERROR_MESSAGE_DIVIDE_ZERO) }),
        ;

        companion object {
            private val map = entries.associateBy(OPERATOR::operator)

            fun get(operation: String): OPERATOR? {
                return map[operation]
            }
        }
    }

    companion object {
        const val SEPARATOR = " "

        const val ERROR_MESSAGE_ILLEGAL_FORMULAS = "정의되지 않은 연산자입니다."
        const val ERROR_MESSAGE_ILLEGAL_OPERATOR = "정의되지 않은 연산자입니다."
        const val ERROR_MESSAGE_ILLEGAL_OPERAND = "숫자가 아닌값이 입력되었습니다."
        const val ERROR_MESSAGE_DIVIDE_ZERO = "0으로는 나눌수 없습니다."
    }

    fun calculate(formulas: String): Double {
        val factors = split(formulas)
        if (factors.isEmpty() || (factors.size % 2 != 1)) {
            throw IllegalArgumentException(ERROR_MESSAGE_ILLEGAL_FORMULAS)
        }

        var result = factors[0].toDoubleOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE_ILLEGAL_OPERAND)
        for (i in 1 until factors.size step 2) {
            val operator = OPERATOR.get(factors[i]) ?: throw IllegalArgumentException(ERROR_MESSAGE_ILLEGAL_OPERATOR)
            val operand = factors[i + 1].toDoubleOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE_ILLEGAL_OPERAND)
            result = operator.apply(result, operand)
        }

        return result
    }

    private fun split(formulas: String): List<String> {
        val factors = formulas.trim().split(SEPARATOR)
        return factors
    }
}
