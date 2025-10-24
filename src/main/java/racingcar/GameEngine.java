package racingcar;

import java.util.ArrayList;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Number;
import racingcar.domain.ParticipatingCars;
import racingcar.service.RacingGame;
import racingcar.view.OutputView;

public class GameEngine {

    public void runAll(Number number, RacingGame racingGame) {
        OutputView.printResultPrefix();
        for (int i = 0; i < number.getNumber(); i++) {
            Map<String, Integer> stringIntegerMap = racingGame.runOneTime();
            OutputView.printResult(stringIntegerMap);
        }
    }

    public ArrayList<String> getWinner(ParticipatingCars cars) {
        ArrayList<String> winnerNames = new ArrayList<>();
        int maxPoint = Integer.MIN_VALUE;
        for (Car car : cars.getCars()) {
            if (car.getPosition() >= maxPoint) {
                winnerNames.add(car.getName());
                maxPoint = car.getPosition();
            }
        }
        return winnerNames;
    }

}
