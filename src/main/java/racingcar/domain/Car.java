package racingcar.domain;

public class Car {

    private static final String ERR_CAR_NAME_TOO_LONG = "이름은 5자 이하만 가능합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ERR_CAR_NAME_TOO_LONG);
        }
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
