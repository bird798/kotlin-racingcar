package step3.ui

class InputView(val guide: String) {
    companion object {
        private const val ERROR_MESSAGE = "잘못 입력하셨습니다."
    }

    init {
        if (guide.isBlank()) throw IllegalArgumentException("가이드 문구가 없습니다")
    }

    fun inputNumber(): Int {
        while (true) {
            println(guide)

            val value = readlnOrNull()
            if (isValid(value)) {
                return value!!.toInt()
            }

            println(ERROR_MESSAGE)
        }
    }

    fun isValid(value: String?): Boolean {
        if (value.isNullOrEmpty() || value.toIntOrNull() == null) {
            return false
        }

        if (value.toInt() <= 0) {
            return false
        }

        return true
    }
}
