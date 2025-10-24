package racingcar.view;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final String RESULT_PREFIX = "실행 결과";
    private static final String MARKER = "-";
    private static final String WINNER = "최종 우승자 : ";

    public static void printResult(Map<String, Integer> result) {
        for (Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + MARKER.repeat(entry.getValue()));
        }
        System.out.println();

    }

    public static void printResultPrefix() {
        System.out.println(RESULT_PREFIX);
    }

    public static void printWinner(ArrayList<String> winnerNames) {
        System.out.print(WINNER);
        System.out.println(String.join(", ",winnerNames));
    }
}

