package step2

class Calculator() {
    fun calculate(formula: String): Double {
        val factors = split(formula)
        // 리스트가 비어 있거나, Factor가 홀수가 아니거나.
        if (factors.isEmpty() || (factors.size % 2 != 1)) {
            throw IllegalArgumentException("잘못된 수식입니다.")
        }

        var result = 0.0
        var operation = ""
        for (i in 0 until factors.size step 1) {
            if ((i % 2) == 0) {
                // 숫자가 나올 차례
                val number = factors[i].toDoubleOrNull() ?: throw IllegalArgumentException("잘못된 수식입니다.")
                when (operation) {
                    "+" -> result = plus(result, number)
                    "-" -> result = minus(result, number)
                    "*" -> result = multiply(result, number)
                    "/" -> result = divide(result, number)
                    "" -> result = number // 저장된 연산자가 없으면 현재것 저장
                    else -> throw IllegalArgumentException("정의되지 않은 연산자입니다.")
                }
                operation = ""
            } else {
                // 연산자가 나올 차례
                if (factors[i] !in listOf("+", "-", "*", "/")) throw IllegalArgumentException("알수 없는 연산자입니다.")
                operation = factors[i]
            }
        }

        return result
    }

    private fun split(formula: String): List<String> {
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
