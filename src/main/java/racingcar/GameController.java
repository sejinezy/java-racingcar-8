package racingcar;

import static racingcar.view.InputParser.*;

import java.util.List;
import java.util.Map;
import racingcar.domain.Attempts;
import racingcar.domain.ParticipatingCars;
import racingcar.service.GameEngine;
import racingcar.service.PickRandomValue;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final PickRandomValue pickRandomValue;
    private final GameEngine gameEngine;
    private final OutputView outputView;

    public GameController(InputView inputView, PickRandomValue pickRandomValue, GameEngine gameEngine,
                          OutputView outputView) {
        this.inputView = inputView;
        this.pickRandomValue = pickRandomValue;
        this.gameEngine = gameEngine;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = parseValidatedCarNames(inputView.carNamesReadLine());
        String numberInput = validateBlank(inputView.numberReadLine());

        Attempts attempts = new Attempts(numberInput);
        ParticipatingCars participatingCars = new ParticipatingCars(carNames);
        RacingGame racingGame = new RacingGame(participatingCars, pickRandomValue);

        List<Map<String, Integer>> allResult = gameEngine.runAll(attempts, racingGame);

        printGameResult(allResult);
        printWinners(allResult);
    }

    private void printGameResult(List<Map<String, Integer>> allResult) {
        outputView.printResultPrefix();
        for (Map<String, Integer> onetimeResult : allResult) {
            outputView.printResult(onetimeResult);
        }
    }

    private void printWinners(List<Map<String, Integer>> allResult) {
        List<String> winner = getWinners(allResult);
        outputView.printWinner(winner);
    }

    private List<String> getWinners(List<Map<String, Integer>> allResult) {
        return gameEngine.getWinner(allResult.getLast());
    }
}
