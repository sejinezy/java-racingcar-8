package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String ERR_IS_BLANK = "빈 값은 허용되지 않습니다.";
    private static final String REGEX = ",";

    private InputParser() {
    }

    public static String validateBlank(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException(ERR_IS_BLANK);
        }
        return raw.trim();
    }

    public static List<String> parseCarNames(String raw) {
        validateBlank(raw);
        List<String> carNames = new ArrayList<>();
        String[] split = raw.split(REGEX, -1);
        for (String carName : split) {
            String validatedInput = validateBlank(carName);
            carNames.add(validatedInput);
        }
        return carNames;
    }
}
