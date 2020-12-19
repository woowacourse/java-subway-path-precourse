package subway.view;

import java.util.Arrays;

public enum MainView {
    FIND("1", "경로 조회"),
    QUIT("Q" , "종료");

    private static final String VIEW_FORM = "%s. %s \n";
    private final String key;
    private final String name;

    MainView(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String getViewNames() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(values())
                .forEach(value -> stringBuilder.append(String.format(VIEW_FORM, value.key, value.name)));
        return stringBuilder.toString();
    }

    public static MainView getView(String key) {
        return Arrays.stream(values())
                .filter(value -> value.key.equals(key))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("올바르지 않는 보기를 선택하셨습니다."));
    }
}
