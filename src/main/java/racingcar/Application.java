package racingcar;


import racingcar.service.DefaultPickRandomValue;
import racingcar.service.PickRandomValue;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        PickRandomValue pickRandomValue = new DefaultPickRandomValue();
        GameEngine gameEngine = new GameEngine();
        OutputView outputView = new OutputView();

        GameController gameController = new GameController(inputView, pickRandomValue, gameEngine, outputView);
        gameController.run();
    }
}
