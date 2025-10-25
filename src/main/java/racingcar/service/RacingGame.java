package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.ParticipatingCars;

public class RacingGame {

    private final ParticipatingCars participatingCars;
    private final PickRandomValue pickRandomValue;

    public RacingGame(ParticipatingCars participatingCars, PickRandomValue pickRandomValue) {
        this.participatingCars = participatingCars;
        this.pickRandomValue = pickRandomValue;
    }

    public Map<String, Integer> runOneTime() {
        for (Car car : participatingCars.getCars()) {
            operate(car);
        }
        return resultOneTime();
    }

    private Map<String, Integer> resultOneTime() {
        Map<String, Integer> gameResult = new LinkedHashMap<>();
        for (Car car : participatingCars.getCars()) {
            gameResult.put(car.getName(), car.getPosition());
        }
        return gameResult;
    }

    private void operate(Car car) {
        int randomValue = pickRandomValue.pick();

        if (randomValue >= 4) {
            car.moveForward();
        }
    }


}
