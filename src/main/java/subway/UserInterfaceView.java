package subway;

public class UserInterfaceView {

    public UserInterfaceView() {
    }

    public void start() {
        while (true) {
            if (printMainViewAndReturnIsEnd()) {
                break;
            }
        }
    }

    private boolean printMainViewAndReturnIsEnd() {
        Output.printMainView();
        return false;
    }


}
