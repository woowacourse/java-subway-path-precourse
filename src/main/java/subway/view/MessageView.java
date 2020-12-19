package subway.view;

public class MessageView {

    private static final String DEPARTURE_INPUT_MESSAGE = "\n## 출발역을 입력하세요.";
    private static final String ARRIVAL_INPUT_MESSAGE = "\n## 도착역을 입력하세요.";

    public static void printDepartureInputMessage() {
        System.out.println(DEPARTURE_INPUT_MESSAGE);
    }

    public static void printArrivalInputMessage() {
        System.out.println(ARRIVAL_INPUT_MESSAGE);
    }

}
