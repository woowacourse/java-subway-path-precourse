package subway.view.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Screen {
    MAIN("메인 화면", Arrays.asList("1. 경로 조회", "Q. 종료")),
    PATH("경로 기준", Arrays.asList("1. 최단 거리", "2. 최소 시간", "Q. 종료"));

    private String title;
    private List<String> functionList;

    Screen(String title, List<String> functionList){
        this.title = title;
        this.functionList = functionList;
    }

    public String getTitle(){
        return title;
    }

    public List<String> getFunctionList() {
        return functionList;
    }

    public List<String> getFunctionCodeList() {
        return functionList.stream()
                .map(n -> n.substring(0, 1))
                .collect(Collectors.toList());
    }
}
