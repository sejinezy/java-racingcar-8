package racingcar;

import static racingcar.view.InputParser.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.domain.Attempts;
import racingcar.domain.ParticipatingCars;
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

        List<String> parsedCarNames = parseCarNames(inputView.carNamesReadLine());

        String numberInput = inputView.numberReadLine();
        validateBlank(numberInput);
        Attempts attempts = new Attempts(numberInput);

        ParticipatingCars participatingCars = new ParticipatingCars(parsedCarNames);
        RacingGame racingGame = new RacingGame(participatingCars, pickRandomValue);
        List<Map<String, Integer>> allResult = gameEngine.runAll(attempts, racingGame);

        outputView.printResultPrefix();
        for (Map<String, Integer> onetimeResult : allResult) {
            outputView.printResult(onetimeResult);
        }
        ArrayList<String> winner = gameEngine.getWinner(allResult.getLast());
        outputView.printWinner(winner);

    }
}
