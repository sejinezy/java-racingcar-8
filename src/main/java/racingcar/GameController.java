package racingcar;

import static racingcar.view.InputParser.*;

import java.util.List;
import java.util.Map;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final StartRacingUseCase startRacingUseCase;
    private final OutputView outputView;

    public GameController(InputView inputView, StartRacingUseCase startRacingUseCase,
                          OutputView outputView) {
        this.inputView = inputView;
        this.startRacingUseCase = startRacingUseCase;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = parseValidatedCarNames(inputView.carNamesReadLine());
        String attemptsInput = validateBlank(inputView.numberReadLine());

        List<Map<String, Integer>> allResult = startRacingUseCase.execute(carNames, attemptsInput);

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
        List<String> winner = startRacingUseCase.extractWinners(allResult);
        outputView.printWinner(winner);
    }

}
