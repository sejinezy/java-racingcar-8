package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.ParticipatingCars;

public class RacingGame {

    private final ParticipatingCars participatingCars;

    public RacingGame(ParticipatingCars participatingCars) {
        this.participatingCars = participatingCars;
    }

    public Map<String,Integer> runOneTime() {
        for (Car car : participatingCars.getCars()) {
            operate(car);
        }
        return ResultOneTime();
    }

    private Map<String, Integer> ResultOneTime() {
        Map<String, Integer> result = new HashMap<>();

        for (Car car : participatingCars.getCars()) {
            result.put(car.getName(), car.getPosition());
        }

        return result;
    }

    private void operate(Car car) {
        int randomValue = pickRandomValue();

        if (randomValue >= 4) {
            car.moveForward();
        }
    }

    private int pickRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }


}
