package racingcar;


import racingcar.service.DefaultPickRandomValue;
import racingcar.service.GameEngine;
import racingcar.service.PickRandomValue;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        PickRandomValue pickRandomValue = new DefaultPickRandomValue();
        GameEngine gameEngine = new GameEngine();
        OutputView outputView = new OutputView();
        StartRacingUseCase startRacingUseCase = new StartRacingUseCase(pickRandomValue, gameEngine);

        GameController gameController = new GameController(inputView, startRacingUseCase, outputView);
        gameController.run();
    }
}
