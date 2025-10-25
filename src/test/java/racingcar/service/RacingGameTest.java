package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.domain.ParticipatingCars;

class RacingGameTest {

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
    void 랜덤값이_4_이상이면_전진한다() {
        ParticipatingCars participatingCars = new ParticipatingCars(List.of("pobi", "woni"));
        PickRandomValue value = new AlwaysMovePicker();
        RacingGame racingGame = new RacingGame(participatingCars, value);

        Map<String, Integer> oneTimeResult = racingGame.runOneTime();
        Map<String, Integer> exactedResult = Map.of("pobi", 1, "woni", 1);
        assertThat(oneTimeResult).containsExactlyInAnyOrderEntriesOf(exactedResult);
    }

    @Test
    void 랜덤값이_4_미만이면_전진하지_않는다() {
        ParticipatingCars participatingCars = new ParticipatingCars(List.of("pobi", "woni"));
        PickRandomValue value = new NeverMovePicker();
        RacingGame racingGame = new RacingGame(participatingCars, value);

        Map<String, Integer> oneTimeResult = racingGame.runOneTime();
        Map<String, Integer> exactedResult = Map.of("pobi", 0, "woni", 0);
        assertThat(oneTimeResult).containsExactlyInAnyOrderEntriesOf(exactedResult);
    }

    @Test
    void 각각의_결과지는_다음턴에_영향받지_않는다() {
        ParticipatingCars participatingCars = new ParticipatingCars(List.of("pobi", "woni"));
        PickRandomValue value = new AlwaysMovePicker();
        RacingGame racingGame = new RacingGame(participatingCars, value);

        Map<String, Integer> oneTimeResult = racingGame.runOneTime();
        Map<String, Integer> twoTimeResult = racingGame.runOneTime();

        assertThat(oneTimeResult).containsExactlyInAnyOrderEntriesOf(Map.of("pobi", 1, "woni", 1));
        assertThat(twoTimeResult).containsExactlyInAnyOrderEntriesOf(Map.of("pobi", 2, "woni", 2));
    }

    @Test
    void 결과지는_참가하는_자동차의_순서를_보장한다() {
        ParticipatingCars participatingCars = new ParticipatingCars(List.of("pobi", "woni"));
        PickRandomValue value = new AlwaysMovePicker();
        RacingGame racingGame = new RacingGame(participatingCars, value);

        Map<String, Integer> oneTimeResult = racingGame.runOneTime();

        LinkedHashMap<String, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put("pobi", 1);
        expectedResult.put("woni", 1);

        assertThat(oneTimeResult).containsExactlyEntriesOf(expectedResult);

    }

}