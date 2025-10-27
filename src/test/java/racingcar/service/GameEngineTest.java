package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.domain.Attempts;
import racingcar.domain.ParticipatingCars;
import racingcar.domain.RacingTurnRunner;
import racingcar.domain.port.PickRandomValue;

class GameEngineTest {

    private static class AlwaysMovePicker implements PickRandomValue {
        @Override
        public int pickRandomNumber() {
            return 4;
        }
    }

    private static class NeverMovePicker implements PickRandomValue {
        @Override
        public int pickRandomNumber() {
            return 3;
        }
    }

    @Test
    void 시도_횟수만큼_라운드를_반복한다() {
        Attempts attempts = new Attempts("2");
        ParticipatingCars participatingCars = new ParticipatingCars(List.of("pobi", "woni"));
        PickRandomValue value = new AlwaysMovePicker();
        RacingTurnRunner racingGame = new RacingTurnRunner(participatingCars, value);

        GameEngine gameEngine = new GameEngine();
        List<Map<String, Integer>> gameResults = gameEngine.runAll(attempts, racingGame);

        assertThat(gameResults.size()).isEqualTo(attempts.getNumber());
    }

    @Test
    void 각각의_라운드의_결과를_보관한다() {
        Attempts attempts = new Attempts("2");
        ParticipatingCars participatingCars = new ParticipatingCars(List.of("pobi", "woni"));
        PickRandomValue value = new AlwaysMovePicker();
        RacingTurnRunner racingGame = new RacingTurnRunner(participatingCars, value);

        GameEngine gameEngine = new GameEngine();
        List<Map<String, Integer>> gameResults = gameEngine.runAll(attempts, racingGame);

        Map<String, Integer> firstTimeResult = gameResults.getFirst();
        Map<String, Integer> secondTimeResult = gameResults.get(1);

        assertThat(firstTimeResult).containsExactlyInAnyOrderEntriesOf(Map.of("pobi", 1, "woni", 1));
        assertThat(secondTimeResult).containsExactlyInAnyOrderEntriesOf(Map.of("pobi", 2, "woni", 2));
    }

    @Test
    void 한명의_우승자를_반환한다() {
        GameEngine gameEngine = new GameEngine();

        Map<String, Integer> lastResult = Map.of("pobi", 2, "woni", 0);
        List<String> winner = gameEngine.getWinner(lastResult);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner).containsExactly("pobi");
    }

    @Test
    void 공동_우승자를_반환한다() {
        GameEngine gameEngine = new GameEngine();

        LinkedHashMap<String, Integer> lastResult = new LinkedHashMap<>();
        lastResult.put("pobi", 2);
        lastResult.put("woni", 2);
        List<String> winner = gameEngine.getWinner(lastResult);

        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner).containsExactly("pobi", "woni");
    }
}