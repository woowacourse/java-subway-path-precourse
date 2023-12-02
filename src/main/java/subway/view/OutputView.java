package subway.view;

import subway.util.message.InputMessage;
import subway.util.message.Menu;
import subway.util.message.OutputMessage;

import java.util.List;

public class OutputView {
    private static final String KILLOMETER = "km";
    private static final String MINUTE = "분";
    private static final String INFO_TAG = "[INFO] ";
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLine(){
        System.out.println();
    }
    public static void printMain(){
        System.out.println(InputMessage.MAIN_SCREEN.getValue());
        System.out.println(Menu.SELECT_ROUTINE.getValue());
        System.out.println(Menu.EXIT.getValue());
    }

    public static void printRoutine(){
        System.out.println(InputMessage.ROUTINE.getValue());
        System.out.println(Menu.SHORTEST_DISTANCE.getValue());
        System.out.println(Menu.SHORTEST_TIME.getValue());
        System.out.println(Menu.BACK.getValue());
    }

    public static void printResult(final List<String> path, final int totalDistance, final int totalTime){
        System.out.println(InputMessage.SELECT_RESULT.getValue());
        System.out.println(OutputMessage.DASH.getValue());
        System.out.println(OutputMessage.TOTAL_DISTANCE.getValue() + totalDistance + KILLOMETER);
        System.out.println(OutputMessage.TOTAL_TIME.getValue() + totalTime + MINUTE);
        System.out.println(OutputMessage.DASH.getValue());
        for(String vertex : path){
            System.out.println(INFO_TAG + vertex);
        }
        OutputView.printLine();
    }
}
