package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultPickRandomValue implements PickRandomValue {

    @Override
    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
