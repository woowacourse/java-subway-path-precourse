package subway.domain.function;

import java.util.Arrays;
import java.util.Scanner;
import subway.view.OutputView;

public enum FindRouteFunction {
    FIND_SHORTEST_ROUTE("1") {
        @Override
        public void operate(Scanner scanner) {
        }
    },
    FIND_MINIMUM_TIME_ROUTE("2") {
        @Override
        public void operate(Scanner scanner) {
        }
    },
    BACK("B") {
        @Override
        public void operate(Scanner scanner) {
        }    
    };

    private String number;

    FindRouteFunction(String number) {
        this.number = number;
    }

    public static FindRouteFunction getFindRouteFunctionByNumber(String inputNumber) {
        return Arrays.stream(FindRouteFunction.values())
            .filter(function -> function.number.equals(inputNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public abstract void operate(Scanner scanner);
}
