package subway.Category;

import java.util.Arrays;
import java.util.List;

public enum Category {
    MAIN(
            "\n## 메인 화면",
            "1. 경로 조회\nQ. 종료",
            Arrays.asList("1", "Q")),
    ROUTE(
            "\n## 경로 기준",
            "1. 최단 거리\n2. 최소 시간\nB. 돌아가기",
            Arrays.asList("1", "2", "B"));

    private final String name;
    private final String actionOrder;
    private final List<String> actionType;

    Category(String name, String actionOrder, List<String> actionType) {
        this.name = name;
        this.actionOrder = actionOrder;
        this.actionType = actionType;
    }

    public String getName() {
        return name;
    }

    public String getActionOrder() {
        return actionOrder;
    }

    public List<String> getActionType() {
        return actionType;
    }

    public void isValidFunction(String input, List<String> actionType) {
        Validator.isValidCategory(input, actionType);
    }
}
