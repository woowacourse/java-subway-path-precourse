package subway.view.output;

public class RouteLookupOutputView {
    public void printMenu(){
        System.out.println("## 경로 기준\n" +
                "1. 최단 거리\n" +
                "2. 최소 시간\n" +
                "B. 돌아가기\n");
    }
}
