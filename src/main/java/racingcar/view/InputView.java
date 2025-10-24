package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_PREFIX = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_PREFIX = "시도할 횟수는 몇 회인가요?";

    public static String carNamesReadLine() {
        System.out.println(CAR_NAMES_PREFIX);
        return Console.readLine();
    }

    public static String numberReadLine() {
        System.out.println(NUMBER_PREFIX);
        return Console.readLine();
    }

    public static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }
    }

    public static String[] parse(String input) {
        return input.split(",");
    }
}
