package racingcar.domain;

public class Number {

    private final int number;

    public Number(String rawInput) {
        int parsedInt = parseInt(rawInput);
        validate(parsedInt);
        this.number = parsedInt;
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 숫자만 가능합니다.");
        }
    }

    private static boolean isPositive(int number) {
        if (number > 0) {
            return true;
        }
        return false;
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
