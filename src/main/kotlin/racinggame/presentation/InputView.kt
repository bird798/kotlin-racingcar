package racinggame.presentation

class InputView(val guide: String) {
    companion object {
        private const val ERROR_INVALID_STRING = "잘못 입력하셨습니다."
        private const val ERRRR_GUIDE_IS_EMPTY = "가이드 문구가 없습니다"
    }

    init {
        require(guide.isNotBlank()) { ERRRR_GUIDE_IS_EMPTY }
    }

    fun inputNumber(): Int {
        while (true) {
            println(guide)

            val value = readlnOrNull()
            if (isValid(value)) {
                return value!!.toInt()
            }

            println(ERROR_INVALID_STRING)
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
