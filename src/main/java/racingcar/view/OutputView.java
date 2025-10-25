package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final String RESULT_PREFIX = "실행 결과";
    private static final String CAR_POSITION_MARKER = "-";
    private static final String WINNER = "최종 우승자 : ";
    private static final String RESULT_ENTRY_DELIMITER = " : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printResult(Map<String, Integer> result) {
        for (Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + RESULT_ENTRY_DELIMITER + CAR_POSITION_MARKER.repeat(entry.getValue()));
        }
        System.out.println();

    }

    public void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public void printWinner(List<String> winnerNames) {
        System.out.print(WINNER);
        System.out.println(String.join(WINNER_DELIMITER, winnerNames));
    }
}

