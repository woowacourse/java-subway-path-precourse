package subway.console;

import java.util.Arrays;

public enum PathCriteriaMenu {
    SHORTEST_DISTANCE("최단 거리", "1") {
        @Override
        void execute() {
            // todo: 두 역의 최단 거리 찾는 과정
        }
    },
    MINIMUM_TIME("최소 시간", "2") {
        @Override
        void execute() {
            // todo: 두 역의 최소 시간 찾는 과정
        }
    },
    BACK("돌아가기", "B") {
        @Override
        void execute() { }
    };

    private final String name;
    private final String symbol;

    PathCriteriaMenu(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    abstract void execute();

    public static void executeMenuByInput(String input) {
        try {
            Arrays.stream(PathCriteriaMenu.values())
                .filter(menu -> menu.getSymbol().equals(input))
                .findAny()
                .get()
                .execute();
        } catch (Exception e) {
            throw new IllegalMenuInputException();
        }

    }
}
