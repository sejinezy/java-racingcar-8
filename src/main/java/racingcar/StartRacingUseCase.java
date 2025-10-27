package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.domain.Attempts;
import racingcar.domain.ParticipatingCars;
import racingcar.service.GameEngine;
import racingcar.service.PickRandomValue;
import racingcar.service.RacingGame;

public class StartRacingUseCase {

    private final PickRandomValue pickRandomValue;
    private final GameEngine gameEngine;

    public StartRacingUseCase(PickRandomValue pickRandomValue, GameEngine gameEngine) {
        this.pickRandomValue = pickRandomValue;
        this.gameEngine = gameEngine;
    }

    public List<Map<String, Integer>> execute(List<String> carNames, String attemptsInput) {
        ParticipatingCars participatingCars = new ParticipatingCars(carNames);
        RacingGame racingGame = new RacingGame(participatingCars,pickRandomValue);
        Attempts attempts = new Attempts(attemptsInput);

        return gameEngine.runAll(attempts, racingGame);
    }

    public List<String> extractWinners(List<Map<String, Integer>> allResult) {
        return gameEngine.getWinner(allResult.getLast());

    }
}
