package subway.view;

import subway.Constant;
import subway.domain.Path;
import subway.domain.Station;

import java.util.List;

public class Output {
    private static String READ_PATH = "경로 조회";
    private static String QUIT = "종료";
    private static String SHORTEST_PATH = "최단 거리";
    private static String SHORTEST_TIME = "최소 시간";
    private static String BACK = "돌아가기";
    private static String BAR = "---";
    private static String TOTAL_LENGTH = "총 거리 : %dkm";
    private static String TOTAL_TIME = "총 소요 시간 : %d분";

    public static void printMainFunction(){
        System.out.println("\n## 메인 화면");
        System.out.println(String.join(". ", Constant.COMMAND_ONE, READ_PATH));
        System.out.println(String.join(". ", Constant.COMMAND_QUIT, QUIT));
    }

    public static void printPathStandard(){
        System.out.println("\n## 경로 기준");
        System.out.println(String.join(". ", Constant.COMMAND_ONE, SHORTEST_PATH));
        System.out.println(String.join(". ", Constant.COMMAND_TWO, SHORTEST_TIME));
        System.out.println(String.join(". ", Constant.COMMAND_BACK, BACK));
    }

    public static void printPathResult(Path path){
        List<Station> pathList = path.getPathList();
        System.out.println(String.join(" ", Constant.PREFIX_INFO, BAR));
        System.out.println(String.join(" ", Constant.PREFIX_INFO, String.format(TOTAL_LENGTH, path.getTotalLength())));
        System.out.println(String.join(" ", Constant.PREFIX_INFO, String.format(TOTAL_TIME, path.getTotalTime())));
        System.out.println(String.join(" ", Constant.PREFIX_INFO, BAR));
        for(int i=0; i<pathList.size(); i++){
            System.out.println(String.join(" ", Constant.PREFIX_INFO, pathList.get(i).getName()));
        }
    }

}
