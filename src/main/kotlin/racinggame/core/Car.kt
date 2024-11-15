package racinggame.core

data class Car(
    val name: String,
    var position: Int,
) {
    init {
        require(name.isNotBlank())
    }

    fun move() {
        position += 1
    }
}
