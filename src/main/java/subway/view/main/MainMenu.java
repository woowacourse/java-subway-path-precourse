package subway.view.main;

import subway.repository.InitialRepository;
import subway.view.path.PathScreen;

import java.util.Arrays;
import java.util.function.Consumer;

public enum MainMenu {
    INQUIRY("1", "경로 조회", (key) -> PathScreen.selectMenu()),
    QUIT("Q", "종료", (key) -> InitialRepository.end());

    private String key;
    private String title;
    private Consumer<String> expression;

    MainMenu(String key, String title, Consumer<String> expression) {
        this.key = key;
        this.title = title;
        this.expression = expression;
    }

    public void request(String key){
        expression.accept(key);
    }

    public static MainMenu findMenuByKey(String key) {
        return Arrays.stream(values())
                .filter(menu -> menu.getKey().equals(key))
                .findAny()
                .get();
    }

    public static boolean isValidInput(String input) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.getKey().equals(input));
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }
}
