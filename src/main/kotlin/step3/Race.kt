package step3

import step3.condition.MoveCondition

class Race(carCount: Int, moveCondition: MoveCondition) {
    init {
        if (carCount <= 0) throw IllegalArgumentException("잘못된 레이싱 정보로 인해 레이싱을 시작할 수 없습니다.")
    }

    val cars: MutableList<Car> = MutableList(carCount) { index -> Car("#${index + 1}", moveCondition::canMove) }

    fun move() {
        cars.forEach { car -> car.tryMove() }
    }
}
