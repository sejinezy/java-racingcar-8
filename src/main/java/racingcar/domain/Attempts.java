package racingcar.domain;

public class Attempts {

    private final int number;

    public Attempts(String rawInput) {
        int parsedInt = parseInt(rawInput);
        validate(parsedInt);
        this.number = parsedInt;
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 숫자만 가능합니다.");
        }
    }

    private static boolean isPositive(int number) {
        return number > 0;
    }

    private void validate(int number) {
        if (!isPositive(number)) {
            throw new IllegalArgumentException("1 이상이어야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
