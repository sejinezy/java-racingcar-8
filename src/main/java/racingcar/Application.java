package racingcar;

import java.util.ArrayList;
import racingcar.domain.Number;
import racingcar.domain.ParticipatingCars;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {


        String carNamesInput = InputView.carNamesReadLine();
        InputView.validateBlank(carNamesInput);

        String numberInput = InputView.numberReadLine();
        InputView.validateBlank(numberInput);
        Number number = new Number(numberInput);

        String[] parsed = InputView.parse(carNamesInput);

        ParticipatingCars participatingCars = new ParticipatingCars(parsed);


        RacingGame racingGame = new RacingGame(participatingCars);
        GameEngine gameEngine = new GameEngine();
        gameEngine.runAll(number, racingGame);
        ArrayList<String> winner = gameEngine.getWinner(participatingCars);

        OutputView.printWinner(winner);

    }
}
