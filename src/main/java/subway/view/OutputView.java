package subway.view;

public class OutputView {
    OutputMessages outputMessages;

    public OutputView() {
        this.outputMessages = new OutputMessages();
    }

    public void mainView() {
        System.out.println(outputMessages.MAIN_VIEW);
        String[] messages = outputMessages.MAIN_OPTIONS;
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void getUserOption() {
        System.out.println(outputMessages.SELECT_OPTION);
    }

    public void mapView() {
        System.out.println(outputMessages.MAP_VIEW);
        String[] messages = outputMessages.MAP_OPTIONS;
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void getUserStart() {
        System.out.println(outputMessages.INPUT_START);
    }

    public void getUserArrive() {
        System.out.println(outputMessages.INPUT_ARRIVE);
    }
}
