package racinggame.presentation

class InputView(val guide: String) {
    companion object {
        private const val ERROR_INVALID_STRING = "잘못 입력하셨습니다."
        private const val ERROR_GUIDE_IS_EMPTY = "가이드 문구가 없습니다"
        private const val RETRY_MAX_COUNT = 5
    }

    init {
        require(guide.isNotBlank()) { ERROR_GUIDE_IS_EMPTY }
    }

    fun inputNumber(): Int {
        for (i in 0 until RETRY_MAX_COUNT) {
            println(guide)

            val value = readlnOrNull()
            if (isValid(value)) {
                return value!!.toInt()
            }

            println(ERROR_INVALID_STRING)
        }

        return 0
    }

    fun isValid(value: String?): Boolean {
        val convertedValue = value?.toIntOrNull()
        return convertedValue != null && convertedValue > 0
    }
}
