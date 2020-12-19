package subway.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MenuType {
    PATH_FIND("1","경로 조회", Arrays.asList(ActionType.SHORTEST_PATH,ActionType.MINIMUM_TIME,ActionType.BACK)),
    QUIT("Q","종료", Collections.emptyList());

    private String key;
    private String name;
    private List<ActionType> action;

    MenuType(String key,String name,List<ActionType> action){
        this.key=key;
        this.name=name;
        this.action=action;
    }

    public List<ActionType> getAction() {
        return action;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static boolean isValidInput(String input){
        return Arrays.stream(MenuType.values()).anyMatch(value->value.key.equals(input));
    }
}
