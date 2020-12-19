package subway.view;

import subway.Constant;

public class Output {
    private static String READ_PATH = "경로 조회";
    private static String QUIT = "종료";
    private static String SHORTEST_PATH = "최단 거리";
    private static String SHORTEST_TIME = "최소 시간";
    private static String BACK = "돌아가기";

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

}
