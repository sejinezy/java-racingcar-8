package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class ParticipatingCars {

    private final List<Car> cars = new ArrayList<>();

    public ParticipatingCars(List<String> cars) {
        validateCars(cars);
        validateSize(cars);
        for (String car : cars) {
            this.cars.add(new Car(car));
        }
    }

    private void validateCars(List<String> cars) {
        if (cars.size() != new HashSet<>(cars).size()) {
            throw new IllegalArgumentException("한 게임의 자동차 이름은 모두 달라야 합니다.");
        }
    }

    private void validateSize(List<String> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("한 게임의 자동차는 2대 이상이어야 합니다.");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
