package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;

public enum MainMenu {
    PATH_FIND("1", "경로 조회", (key) -> PathFindDisplay.loadMenu()),
    QUIT("Q", "종료", (key) -> back());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    MainMenu(final String key, final String name, final Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    private static void back() {
    }

    public static MainMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(menu ->
            menu.key.equals(input))
            .findAny()
            .get();
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        select.accept(key);
    }
}
