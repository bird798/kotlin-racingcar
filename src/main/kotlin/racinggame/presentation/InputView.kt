package racinggame.presentation

object InputView {
    private const val ERROR_INVALID_STRING = "잘못 입력하셨습니다."
    private const val CAR_COUNT_GUIDE_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val MOVEMENT_COUNT_GUIDE_TEXT = "시도할 횟수는 몇 회인가요?"
    private const val DELIMITER = ","

    fun inputStrings(): List<String> {
        println(CAR_COUNT_GUIDE_TEXT)
        val value = readlnOrNull()
        return split(value)
    }

    fun split(value: String?): List<String> {
        require(!value.isNullOrBlank()) { ERROR_INVALID_STRING }

        val strings = value.trim().split(DELIMITER)
        return strings
    }

    fun inputNumber(): Int {
        println(MOVEMENT_COUNT_GUIDE_TEXT)

        val value = readlnOrNull()
        require(isValidNumber(value)) { ERROR_INVALID_STRING }
        return value!!.toInt()
    }

    fun isValidNumber(value: String?): Boolean {
        val convertedValue = value?.toIntOrNull()
        return convertedValue != null && convertedValue > 0
    }
}
