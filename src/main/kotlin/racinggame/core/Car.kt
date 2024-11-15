package racinggame.core

class Car(val name: String, val canMove: () -> Boolean) {
    var moveCount = 0

    fun tryMove() {
        if (canMove()) {
            moveCount += 1
        }
    }
}
