package racinggame.presentation

class InputView(val guide: String) {
    companion object {
        private const val ERROR_INVALID_STRING = "잘못 입력하셨습니다."
        private const val ERROR_GUIDE_IS_EMPTY = "가이드 문구가 없습니다"
    }

    init {
        require(guide.isNotBlank()) { ERROR_GUIDE_IS_EMPTY }
    }

    fun inputStrings(
        delimiter: String,
        maxLength: Int,
    ): List<String> {
        println(guide)
        val value = readlnOrNull()

        return split(value, delimiter, maxLength)
    }

    fun split(
        value: String?,
        delimiter: String,
        maxLength: Int,
    ): List<String> {
        require(!value.isNullOrBlank()) { ERROR_INVALID_STRING }

        val strings = value.trim().split(delimiter)
        strings.forEach { str ->
            require(str.length <= maxLength) { ERROR_INVALID_STRING }
        }

        return strings
    }

    fun inputNumber(): Int {
        println(guide)

        val value = readlnOrNull()
        require(isValidNumber(value)) { ERROR_INVALID_STRING }
        return value!!.toInt()
    }

    fun isValidNumber(value: String?): Boolean {
        val convertedValue = value?.toIntOrNull()
        return convertedValue != null && convertedValue > 0
    }
}
