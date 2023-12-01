package subway.view;

import subway.util.message.InputMessage;
import subway.util.message.Menu;
import subway.util.message.OutputMessage;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printMain(){
        System.out.println(InputMessage.MAIN_SCREEN.getValue());
        System.out.println(Menu.SELECT_ROUTINE.getValue());
        System.out.println(Menu.EXIT.getValue());
    }

    public static void printRoutine(){
        System.out.println(Menu.SHORTEST_DISTANCE.getValue());
        System.out.println(Menu.SHORTEST_TIME.getValue());
        System.out.println(Menu.BACK.getValue());
    }
}
