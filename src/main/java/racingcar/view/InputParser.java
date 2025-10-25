package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static void validateBlank(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }
    }

    public static List<String> parseCarNames(String raw) {
        validateBlank(raw);
        List<String> carNames = new ArrayList<>();
        String[] split = raw.split(",",-1);
        for (String carName : split) {
            validateBlank(carName.trim());
            carNames.add(carName.trim());
        }
        return carNames;
    }
}
