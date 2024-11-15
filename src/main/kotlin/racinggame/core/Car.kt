package racinggame.core

data class Car(
    val name: String,
    var position: Int,
) {
    fun move() {
        position += 1
    }
}
