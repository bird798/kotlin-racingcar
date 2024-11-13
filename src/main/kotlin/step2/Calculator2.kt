package step2

class Calculator2() {
    fun calculate(formula: String): Double {
        val factors = splitFomula(formula)
        if (factors.isEmpty()) {
            throw IllegalArgumentException("빈 문자열입니다")
        }

        var result = 0.0
        var operation = ""

        for (factor in factors) {
            val number = factor.toDoubleOrNull()
            if (number != null) {
                when (operation) {
                    "+" -> result = plus(result, number)
                    "-" -> result = minus(result, number)
                    "*" -> result = multiply(result, number)
                    "/" -> result = divide(result, number)
                    "" -> result = number
                    else -> throw IllegalArgumentException("정의되지 않은 연산자입니다.")
                }
                operation = ""
            } else {
                operation = factor
            }
        }

        return result
    }

    private fun splitFomula(formula: String): List<String> {
        val factors = formula.trim().split(" ")
        if (factors.isEmpty()) {
            throw IllegalArgumentException()
        }
        return factors
    }

    private fun plus(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 + num2
    }

    private fun minus(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 - num2
    }

    private fun multiply(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 * num2
    }

    private fun divide(
        num1: Double,
        num2: Double,
    ): Double {
        return num1 / num2
    }
}
