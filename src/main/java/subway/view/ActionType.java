package subway.view;

import java.util.Arrays;

public enum ActionType {

    SHORTEST_PATH("1","최단 거리"),
    MINIMUM_TIME("2","최소 시간"),
    BACK("B","돌아가기");

    private String key;
    private String name;

    ActionType(String key,String name){
        this.key=key;
        this.name=name;
    }

    public static boolean isValidInput(String input){
        return Arrays.stream(ActionType.values()).anyMatch(value->value.key.equals(input));
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
