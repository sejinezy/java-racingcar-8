package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.domain.Attempts;
import racingcar.domain.RacingTurnRunner;

public class GameEngine {

    public List<Map<String, Integer>> runAll(Attempts attempts, RacingTurnRunner racingGame) {
        List<Map<String, Integer>> gameResults = new ArrayList<>();

        for (int i = 0; i < attempts.getNumber(); i++) {
            gameResults.add(racingGame.runOneTime());
        }
        return gameResults;
    }

    public List<String> getWinner(Map<String, Integer> lastResult) {
        List<String> winnerNames = new ArrayList<>();
        Integer maxPosition = Collections.max(lastResult.values());
        for (Entry<String, Integer> entry : lastResult.entrySet()) {
            if (entry.getValue().equals(maxPosition)) {
                winnerNames.add(entry.getKey());
            }
        }
        return winnerNames;
    }
}
