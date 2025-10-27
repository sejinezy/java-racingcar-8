package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.port.PickRandomValue;

public class RacingTurnRunner {

    private static final int MOVE_THRESHOLD = 4;

    private final ParticipatingCars participatingCars;
    private final PickRandomValue pickRandomValue;

    public RacingTurnRunner(ParticipatingCars participatingCars, PickRandomValue pickRandomValue) {
        this.participatingCars = participatingCars;
        this.pickRandomValue = pickRandomValue;
    }

    public Map<String, Integer> runOneTime() {
        for (Car car : participatingCars.getCars()) {
            operate(car);
        }
        return resultOneTime();
    }

    private void operate(Car car) {
        int randomValue = pickRandomValue.pickRandomNumber();

        if (randomValue >= MOVE_THRESHOLD) {
            car.moveForward();
        }
    }

    private Map<String, Integer> resultOneTime() {
        Map<String, Integer> gameResult = new LinkedHashMap<>();

        for (Car car : participatingCars.getCars()) {
            gameResult.put(car.getName(), car.getPosition());
        }
        return gameResult;
    }

}
