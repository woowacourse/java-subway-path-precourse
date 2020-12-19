package subway.console;

import java.util.Arrays;

public enum MainMenu {
    GET_PATH("경로 조회", "1") {
        @Override
        void execute() {
            PathCriteriaScreen.startProcess();
        }
    },
    QUIT("종료", "Q") {
        @Override
        void execute() { }
    };


    private final String name;
    private final String symbol;

    MainMenu(String name, String symbol) {
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
            Arrays.stream(MainMenu.values())
                .filter(menu -> menu.getSymbol().equals(input))
                .findAny()
                .get()
                .execute();
        } catch (Exception e) {
            throw new IllegalMenuInputException();
        }

    }
}
