package subway.domain;

import java.util.Arrays;

public enum MainFunction {
    FIND_ROUTE("1") {
        @Override
        public void operate() {
        }
    },
    QUIT("Q") {
        @Override
        public void operate() {
        }
    };

    private String number;

    MainFunction(String number) {
        this.number = number;
    }

    public static MainFunction getMainFunctionByNumber(String inputNumber) {
        return Arrays.stream(MainFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public abstract void operate();
}